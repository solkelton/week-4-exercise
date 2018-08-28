package io.training.week4.controller;


import io.training.week4.model.DBInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {

  DBInfo dbinfo;
  public DBController(DBInfo dbinfo){
    this.dbinfo = dbinfo;
  }

  @RequestMapping("/dbinfo")
  public DBInfo getInfo(){
    return this.dbinfo;
  }
}