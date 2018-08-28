package io.training.week4.model;

import org.springframework.stereotype.Component;

@Component
public class SymbolResult {

  private long symbolId;
  private String symbol;

  public SymbolResult(long symbolId, String symbol) {
    this.symbolId = symbolId;
    this.symbol = symbol;
  }

  public SymbolResult() {}

  public long getSymbolId() {
    return symbolId;
  }

  public void setSymbolId(long symbolId) {
    this.symbolId = symbolId;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

}
