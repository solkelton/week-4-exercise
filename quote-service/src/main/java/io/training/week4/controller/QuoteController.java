package io.training.week4.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.training.week4.model.AggregatedData;
import io.training.week4.model.SymbolResult;
import io.training.week4.service.QuoteService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/quote")
public class QuoteController {

  @Value("${symbol.endpoint}") private String endpoint;
  private RestTemplate restTemplate = new RestTemplate();
  private EurekaClient eurekaClient;
  private QuoteService quoteService;

  public QuoteController(QuoteService quoteService, @Qualifier("eurekaClient") EurekaClient eurekaClient) {
    this.quoteService = quoteService;
    this.eurekaClient = eurekaClient;
  }

  @PostMapping("/load")
  public void load() {
    quoteService.load();
  }

  @GetMapping("/{symbol}/{date}")
  public AggregatedData retrieveStockData(@PathVariable("symbol") String symbol, @PathVariable("date") String date) {
    return quoteService.retrieveStockData(retrieveSymbol(symbol), date);
  }

  private SymbolResult retrieveSymbol(String symbol) {
    ParameterizedTypeReference<Resource<SymbolResult>> emp = new ParameterizedTypeReference<Resource<SymbolResult>>() {};
    ResponseEntity<Resource<SymbolResult>> response = restTemplate.exchange(
        RequestEntity.get(URI.create(fetchSymbolServiceUrl(symbol)))
            .accept(MediaTypes.HAL_JSON)
            .build(),
        emp
    );

    assert response != null;
    if(response.getStatusCode() == HttpStatus.OK){
      SymbolResult symbolResult = response.getBody().getContent();
      assert symbolResult != null;
      return symbolResult;
    } else
      return new SymbolResult();
  }

  private String fetchSymbolServiceUrl(String symbol) {
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("SYMBOL-SERVICE", false);
    return instance.getHomePageUrl() + endpoint + symbol;
  }
}
