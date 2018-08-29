package io.training.week4.repository;

import io.training.week4.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SymbolRepository extends JpaRepository<Symbol, Long> {

  @Query(value = "select new io.training.week4.model.Symbol(s.symbolId, s.symbol) "
      + "from Symbol s "
      + "where s.symbol = ?1")
  Symbol retrieveSymbol(String stock);
}
