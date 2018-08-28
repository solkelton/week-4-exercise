package io.training.week4.service;

import io.training.week4.model.Symbol;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class SymbolService {

  private List<Symbol> symbolList = new ArrayList<Symbol>() {{
    add(new Symbol(1,"AAPL"));
    add(new Symbol(2,"GOOG"));
    add(new Symbol(3,"MSFT"));
    add(new Symbol(4,"PVTL"));
    add(new Symbol(5,"AMZN"));
  }};

  public List<Symbol> populate() {
    return symbolList;
  }

  public String generateRandomSymbol() {
    return symbolList.get(new Random().nextInt(symbolList.size())).getSymbol();
  }

}
