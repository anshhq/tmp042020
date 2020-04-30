package com.school.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariDataSource;

@Service
public class DBCPService {
	    @Autowired
	    DataSource dataSource;
	    
	    ArrayList<String> dataPool = new ArrayList<String>();
	 
	    public ArrayList<String> getDBCPInfo()
	    {
	        HikariDataSource ds = (HikariDataSource) dataSource;
	        // dataPool.clear(); // let it append
	        dataPool.add("Instace of DBCP basic data source: " + ds);
	        dataPool.add("Driver class name: " + ds.getDriverClassName());
	        dataPool.add("Connection Pool size : " + ds.getMaximumPoolSize());
	        dataPool.add("Url: " + ds.getJdbcUrl());
					return dataPool;
	    }
	    
	  	@Override
	  	public String toString() {
	  		return dataPool.toString();
	  	}
}
