package com.scrape.portfolio;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DateTest {

	public static void main(String[] args) {
		
		//read spring config file
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		//get the bean from spring container
		DateAndTime dateAndTime = context.getBean("dateAndTime", DateAndTime.class);
		//call methods on the bean
		
		System.out.println("\nDATE: " + dateAndTime.getDate() + "\n");
		System.out.println("\nTIME: " + dateAndTime.getTime() + "\n");
		
		//close the context
		context.close();

	}

}
