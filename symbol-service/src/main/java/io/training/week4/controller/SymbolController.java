package io.training.week4.controller;

import io.training.week4.model.Symbol;
import io.training.week4.service.SymbolService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SymbolController {
  private SymbolService symbolService;

  public SymbolController(SymbolService symbolService) {
    this.symbolService = symbolService;
  }

  @GetMapping("/all")
  public List<Symbol> retrieveAll() {
    return symbolService.retrieveAll();
  }

  @GetMapping("/{symbol}")
  public Symbol retrieveSymbol(@PathVariable("symbol") String symbol) {
    return symbolService.retrieveSymbol(symbol);
  }

}
