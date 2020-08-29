package com.example.inMemorySql;

import com.example.inMemorySql.classes.DB;
import com.example.inMemorySql.classes.Table;
import com.example.inMemorySql.requests.ColumnCreationRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class InMemorySqlApplication {

	public static void main(String[] args){
		SpringApplication.run(InMemorySqlApplication.class, args);

		DB db = new DB();

		ColumnCreationRequest columnCreationRequest1 = ColumnCreationRequest.builder().columnName("roll no").type("int").build();
		ColumnCreationRequest columnCreationRequest2 = ColumnCreationRequest.builder().columnName("name").type("string").build();
		List<ColumnCreationRequest> list = new ArrayList<>();
		list.add(columnCreationRequest1);
		list.add(columnCreationRequest2);
		try{
			db.createTable("student",list);
		}
		catch(Exception e){
			System.out.println("failed to create table");
		}
		Table student = db.getDb().getOrDefault("student",null);
		if(student ==null)
		{
			System.out.println("did not find table in db");
			return;
		}

		HashMap<String,Object> row1 = new HashMap<>();
		row1.put("roll no","1");
		row1.put("name","abcd");

		HashMap<String,Object> row2 = new HashMap<>();
		row2.put("roll no",2);
		row2.put("name","abcd");
		List<HashMap<String,Object>> listOfInserts = new ArrayList<>();
		listOfInserts.add(row1);
		listOfInserts.add(row2);
		try{
			student.insert(listOfInserts);
		}
		catch(Exception e){
			System.out.println("failed to insert table");
		}
	}

}
