package com.example.demo.Util;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ExcelHelper {

    public static Workbook getWorkbook(MultipartFile file) throws IOException {

        return new XSSFWorkbook(file.getInputStream());

    }

}