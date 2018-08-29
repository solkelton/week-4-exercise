package io.training.week4.service;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import io.training.week4.model.Symbol;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class SymbolServiceUnitTest {

  @Mock
  private SymbolService symbolService;

  @Test
  public void testPopulate() {
//    List<Symbol> symbolList = symbolService.populate();
//    assertNotNull(symbolList);
  }

  @Test
  public void testGenerateRandomSymbol() {
////    SymbolService symbolService = new SymbolService();
//    String symbol = symbolService.generateRandomSymbol();
//    assertNotNull(symbol);
  }
}
