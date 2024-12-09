package com.example.reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public byte[] generateReport(String reportName, Map<String, Object> params, InputStream inputStream) throws JRException {
        JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/" + reportName + ".jrxml"));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource((List<?>) params.get("data"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}