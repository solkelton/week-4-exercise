package io.training.week4.service;

import io.training.week4.model.SymbolResult;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="symbol-service")
public interface SymbolService {

  @RequestMapping(method=RequestMethod.GET, value="/all")
  public List<SymbolResult> retrieveAll();

  @RequestMapping(method=RequestMethod.GET, value="{symbol}")
  public SymbolResult retrieveSymbol(@PathVariable("symbol") String symbol);

}
