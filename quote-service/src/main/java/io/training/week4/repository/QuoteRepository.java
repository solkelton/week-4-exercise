package io.training.week4.repository;

import io.training.week4.model.AggregatedData;
import io.training.week4.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

  @Query(value = "select new io.training.week4.model.AggregatedData(max(q.price), min(q.price), sum(q.volume)) "
      + "from Quote q "
      + "where q.symbol= ?1 and function('date_format', q.date, '%Y-%m-%d') = ?2")
  AggregatedData retrieveQuoteData(long id, String date);

  @Query(value = "select price "
      + "from ad_aa0fd39668a85a2.quote q "
      + "where q.symbol = ?1 and date_format(q.date, '%Y-%m-%d') = ?2 "
      + "order by q.date desc limit 1", nativeQuery = true)
  double retrieveClosingPrice(long id, String date);
}
