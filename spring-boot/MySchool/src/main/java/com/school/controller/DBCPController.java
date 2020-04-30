package com.school.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.service.DBCPService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/v1")
public class DBCPController {

	@Autowired
	private DBCPService dbcpService;

	@RequestMapping(value = "/dbcpinfo", method = RequestMethod.GET)

	@ResponseBody
	public ArrayList<String> getDBCPInfo() {
		return dbcpService.getDBCPInfo();
	}

}
