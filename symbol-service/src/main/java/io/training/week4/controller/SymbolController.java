package io.training.week4.controller;

import io.training.week4.model.Symbol;
import io.training.week4.repository.SymbolRepository;
import io.training.week4.service.SymbolService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/symbol")
public class SymbolController {
  private SymbolRepository symbolRepository;

  public SymbolController(SymbolRepository symbolRepository) {
    this.symbolRepository = symbolRepository;
  }

  @GetMapping("/all")
  public List<Symbol> retrieveAll() {
    return symbolRepository.findAll();
  }

  @GetMapping("/{symbol}")
  public Symbol retrieveSymbol(@PathVariable("symbol") String symbol) {
    return symbolRepository.retrieveSymbolData(symbol);
  }

}
