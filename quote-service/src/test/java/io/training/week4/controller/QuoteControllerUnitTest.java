package io.training.week4.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

import io.training.week4.model.AggregatedData;
import io.training.week4.model.Quote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class QuoteControllerUnitTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  QuoteController quoteController;

  @Test
  public void testLoad() throws Exception {
    Quote mockQuote = mock(Quote.class);

    mockMvc.perform(post("/quote/load")
        .contentType(MediaType.APPLICATION_JSON)
        .content(toJson(mockQuote)))
        .andExpect(status().isOk());

    verify(quoteController, times(1)).load();
  }

  @Test
  public void testRetrieveStockData() throws Exception{
    AggregatedData mockAggregatedData = mock(AggregatedData.class);
    String symbol = "MSFT";
    String date = "2018-06-22";

    mockMvc.perform(
        MockMvcRequestBuilders.get("/quote/" + symbol + "/" + date)
            .contentType(MediaType.APPLICATION_JSON)
            .content(toJson(mockAggregatedData)))
            .andExpect(status().isOk());

    verify(quoteController, times(1)).retrieveStockData(symbol, date);
  }
}
