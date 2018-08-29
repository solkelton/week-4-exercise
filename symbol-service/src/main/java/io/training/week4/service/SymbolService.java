package io.training.week4.service;

import io.training.week4.model.Symbol;
import io.training.week4.repository.SymbolRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class SymbolService {

  private SymbolRepository symbolRepository;
  private List<Symbol> symbolList = new ArrayList<Symbol>() {{
    add(new Symbol(1,"AAPL"));
    add(new Symbol(2,"GOOG"));
    add(new Symbol(3,"MSFT"));
    add(new Symbol(4,"PVTL"));
    add(new Symbol(5,"AMZN"));
  }};

  public SymbolService(SymbolRepository symbolRepository) { this.symbolRepository = symbolRepository; }

  public List<Symbol> retrieveAll() { return symbolRepository.findAll(); }

  public Symbol retrieveSymbol(String symbol) { return symbolRepository.retrieveSymbol(symbol); }

  public List<Symbol> getSymbolList() {
    return symbolList;
  }

  public void populate() { symbolRepository.saveAll(getSymbolList()); }

}
