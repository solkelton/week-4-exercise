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
  @Value("${db.limit}") private int limit;
  private final ObjectMapper objectMapper = new ObjectMapper();
  private final TypeFactory typeFactory = objectMapper.getTypeFactory();
  private QuoteRepository quoteRepository;
  private AggregatedData aggregatedData;
  private List<Quote> quoteList;

  public QuoteService(QuoteRepository quoteRepository, AggregatedData aggregatedData) {
    this.quoteRepository = quoteRepository;
    this.aggregatedData = aggregatedData;
  }

  public List<Quote> load() {

    if(quoteList.size() > 0) { quoteList.clear(); }

    try {
      URL jsonUrl = new URL(stockUrl);
      quoteList = objectMapper.readValue(jsonUrl, typeFactory.constructCollectionType(List.class, Quote.class));
      for (int i = 0; i < limit; i++) {
        quoteRepository.save(quoteList.get(i));
      }
      return quoteList;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
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
