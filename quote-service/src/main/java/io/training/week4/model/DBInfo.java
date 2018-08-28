package io.training.week4.model;

import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class DBInfo {
  private String url;

  public DBInfo(javax.sql.DataSource dataSource) throws SQLException {
    this.url = dataSource.getConnection().getMetaData().getURL();
  }

  public String getUrl() {
    return url;
  }
}