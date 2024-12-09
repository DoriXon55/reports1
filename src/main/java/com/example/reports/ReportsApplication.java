package com.example.reports;
import java.io.InputStream;
import java.util.HashMap;

import com.example.reports.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportsApplication implements CommandLineRunner {

	@Autowired
	private ReportService reportService;

	public static void main(String[] args) {
		SpringApplication.run(ReportsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (InputStream is = getClass().getResourceAsStream("/path/to/your/resource")) {
			if (is == null) {
				throw new IllegalArgumentException("Resource not found");
			}
			// Example of calling a method from ReportService
			reportService.generateReport("Flower_3", new HashMap<>(), is);
		}
	}
}