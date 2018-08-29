package io.training.week4.controller;

import io.training.week4.model.AggregatedData;
import io.training.week4.model.SymbolResult;
import io.training.week4.service.QuoteService;
import io.training.week4.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

  @Autowired SymbolService symbolService;
  private QuoteService quoteService;

  public QuoteController(QuoteService quoteService) { this.quoteService = quoteService; }

  @PostMapping("/load")
  public void load() {
    quoteService.load();
  }

  @GetMapping("/{symbol}/{date}")
  public AggregatedData retrieveStockData(@PathVariable("symbol") String symbol, @PathVariable("date") String date) {
    return quoteService.retrieveStockData(retrieveSymbol(symbol), date);
  }

  private SymbolResult retrieveSymbol(String symbol) { return symbolService.retrieveSymbol(symbol); }
}
