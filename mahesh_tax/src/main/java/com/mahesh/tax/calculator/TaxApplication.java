package com.mahesh.tax.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.mahesh.tax.calculator" })
public class TaxApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TaxApplication.class, args);
	}
}
