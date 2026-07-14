package com.example.demo.Util;


import org.springframework.web.multipart.MultipartFile;

import java.security.MessageDigest;

public class FileCheckSumUtil {

    public static String getChecksum(MultipartFile file) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] bytes = md.digest(file.getBytes());

        StringBuilder sb = new StringBuilder();

        for(byte b : bytes){

            sb.append(String.format("%02x", b));

        }

        return sb.toString();

    }

}