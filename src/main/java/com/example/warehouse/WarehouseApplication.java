package com.example.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories
public class WarehouseApplication {
	public static String generateInvoiceNumber() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
		String currentDate = dateFormat.format(new Date());
		int randomPart = new Random().nextInt(900) + 100;
		String invoiceNumber = currentDate + randomPart;
		return invoiceNumber;
	}


	public static void main(String[] args) {

	SpringApplication.run(WarehouseApplication.class, args);
	}

}
