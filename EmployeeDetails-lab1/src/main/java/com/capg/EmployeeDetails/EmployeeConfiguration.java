package com.capg.EmployeeDetails;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.capg.EmployeeDetails")
@PropertySource("app.properties")
public class EmployeeConfiguration {
	

}
