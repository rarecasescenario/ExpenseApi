package app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.TestData;

@RestController
@Produces(MediaType.APPLICATION_JSON)
public class TestRestController {

	private List<String> dataList = new ArrayList<String>(Arrays.asList("Spring Boot", "Rest Service", "Hibernate"));
	
	@RequestMapping("/getdata")
	public TestData getTestData(@RequestParam(value="id", defaultValue="0") Integer id) {
		TestData ts = new TestData(id, dataList.get(id)); 
		return ts;
	}
	
}
