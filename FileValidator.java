package com.example.demo.Util;

import org.springframework.web.multipart.MultipartFile;

public class FileValidator {

    public static boolean isCSV(MultipartFile file){

        return file.getOriginalFilename().endsWith(".csv");

    }

    public static boolean isExcel(MultipartFile file){

        return file.getOriginalFilename().endsWith(".xlsx");

    }

    public static boolean isSupported(MultipartFile file){

        return isCSV(file) || isExcel(file);

    }

}