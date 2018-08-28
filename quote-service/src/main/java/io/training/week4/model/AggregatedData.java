package io.training.week4.model;

import org.springframework.stereotype.Component;

@Component
public class AggregatedData {

  private double maxPrice;
  private double minPrice;
  private long volume;
  private String symbol;
  private double closingPrice;


  public AggregatedData(double maxPrice, double minPrice, long volume) {
    this.maxPrice = maxPrice;
    this.minPrice = minPrice;
    this.volume = volume;
    this.closingPrice = 0.0;
  }

  public AggregatedData() {}

  public double getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(double maxPrice) {
    this.maxPrice = maxPrice;
  }

  public double getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(double minPrice) {
    this.minPrice = minPrice;
  }

  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public double getClosingPrice() { return closingPrice; }

  public void setClosingPrice(double closingPrice) { this.closingPrice = closingPrice; }


}
