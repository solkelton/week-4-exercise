package io.training.week4.model;


import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class QuoteServiceModelUnitTest {

  private String symbol = "AAPL";

  @Mock
  private AggregatedData aggregatedData;

  @Test
  public void testAggregatedData() {

    aggregatedData = new AggregatedData(100.55, 10.23, 123);
    aggregatedData.setSymbol(symbol);

    assertNotNull(aggregatedData);
    assertNotNull(aggregatedData.getVolume());
    assertNotNull(symbol, aggregatedData.getSymbol());
  }

  @Mock
  private SymbolResult symbolResult;

  @Test
  public void testSymbolResult() {
    symbolResult = new SymbolResult(1, "Not Valid Symbol");
    symbolResult.setSymbol(symbol);

    assertNotNull(symbolResult);
    assertNotNull(symbolResult.getSymbolId());
    assertNotNull(symbol, symbolResult.getSymbol());
  }



}
