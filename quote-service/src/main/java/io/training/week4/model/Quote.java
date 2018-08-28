package io.training.week4.model;

import io.training.week4.utils.DateConverter;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quote {

  @Id
  @GeneratedValue
  private long id;
  private long symbol;
  private int volume;
  private double price;
  private Timestamp date;

  public Quote(long symbol, int volume, double price, Timestamp date) {
    this.symbol = symbol;
    this.volume = volume;
    this.price = price;
    this.date = date;
  }

  public Quote() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSymbol() {
    return symbol;
  }

  public void setSymbolId(long symbol) {
    this.symbol = symbol;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = DateConverter.toTimestamp(date);
  }
}
