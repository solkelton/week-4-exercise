package io.training.week4.service;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import io.training.week4.model.Quote;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class QuoteServiceUnitTest {


  private QuoteService quoteService;

  @Test
  public void testLoad() {
    List<Quote> symbolList = quoteService.load();
    assertNotNull(symbolList);
  }
}
