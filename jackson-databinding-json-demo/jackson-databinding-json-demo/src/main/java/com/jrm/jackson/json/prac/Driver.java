package com.jrm.jackson.json.prac;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	
	public static void main(String[] args) {
		
		try {
			//create object mapper
			ObjectMapper objectMapper = new ObjectMapper();
			
			
			//read Json convert to JAVA POJO
			//data/sample-lite.json
			
			Student theStudent = 
					objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			
			
			
			//print names
			
			System.out.println(theStudent.getFirstName());
			System.out.println(theStudent.getLastName());
			
			//printout address
			
			Address address = theStudent.getAddress();
			
			System.out.println("City: "+address.getCity());
			
			for(String lang:theStudent.getLanguages())
			{
				System.out.println(lang);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
	}

}
