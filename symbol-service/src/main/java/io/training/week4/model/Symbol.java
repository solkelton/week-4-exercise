package io.training.week4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Symbol {

  @Id
  @GeneratedValue
  private long id;
  private long symbolId;
  private String symbol;

  public Symbol(long symbolId, String symbol) {
    this.symbolId = symbolId;
    this.symbol = symbol;
  }

  public Symbol() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSymbolId() { return symbolId; }

  public void setSymbolId(int symbolId) { this.symbolId = symbolId; }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

}
