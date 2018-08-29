package io.training.week4.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.training.week4.model.AggregatedData;
import io.training.week4.model.Quote;
import io.training.week4.model.SymbolResult;
import io.training.week4.repository.QuoteRepository;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

  @Value("${stock.data.url}") private String stockUrl;
  private final ObjectMapper objectMapper = new ObjectMapper();
  private final TypeFactory typeFactory = objectMapper.getTypeFactory();
  private QuoteRepository quoteRepository;
  private AggregatedData aggregatedData;

  public QuoteService(QuoteRepository quoteRepository, AggregatedData aggregatedData) {
    this.quoteRepository = quoteRepository;
    this.aggregatedData = aggregatedData;
  }

  public void load() {
    try {
      URL jsonUrl = new URL(stockUrl);
      quoteRepository.saveAll(objectMapper.readValue(jsonUrl, typeFactory.constructCollectionType(List.class, Quote.class)));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public AggregatedData retrieveStockData(SymbolResult symbolResult, String date) {
    setAggregatedData(quoteRepository.retrieveQuoteData(symbolResult.getSymbolId(), date));
    aggregatedData.setSymbol(symbolResult.getSymbol());
    aggregatedData.setClosingPrice(quoteRepository.retrieveClosingPrice(symbolResult.getSymbolId(), date));
    return getAggregatedData();
  }

  public AggregatedData getAggregatedData() {
    return aggregatedData;
  }

  public void setAggregatedData(AggregatedData aggregatedData) {
    this.aggregatedData = aggregatedData;
  }
}
