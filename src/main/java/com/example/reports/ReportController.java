package com.example.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/report/flower")
    public ResponseEntity<byte[]> generateFlowerReport(@RequestParam Map<String, Object> params) throws Exception {
        byte[] report = reportService.generateReport("Flower_3", params, null);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=flower_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(report);
    }
}