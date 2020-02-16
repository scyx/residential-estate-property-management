package com.cyx.residential_estate_property_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cyx.residential_estate_property_management.Dao")
@SpringBootApplication
public class ResidentialEstatePropertyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResidentialEstatePropertyManagementApplication.class, args);
	}

}
