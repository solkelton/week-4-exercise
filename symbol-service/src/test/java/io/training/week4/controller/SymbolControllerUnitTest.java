package io.training.week4.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.training.week4.service.SymbolService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class SymbolControllerUnitTest {

  private MockMvc mockMvc;
  private SymbolService symbolService = new SymbolService();
  private String symbol;

  @Mock
  SymbolController symbolController;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(symbolController).build();
    symbol = symbolService.generateRandomSymbol();
  }

  @Test
  public void testRetrieveAll() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.get("/symbol/all")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

    verify(symbolController).retrieveAll();
  }

  @Test
  public void testRetrieveSymbol() throws Exception {
     mockMvc.perform(
        MockMvcRequestBuilders.get("/symbol/" + symbol)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();

    verify(symbolController).retrieveSymbol(symbol);
  }


}




