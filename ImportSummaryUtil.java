package com.example.demo.Util;


public class ImportSummaryUtil {

    private int total;

    private int success;

    private int failed;

    public ImportSummaryUtil(){}

    public void incrementSuccess(){

        success++;
        total++;

    }

    public void incrementFailed(){

        failed++;
        total++;

    }

    public int getTotal() {

        return total;
    }

    public int getSuccess() {

        return success;
    }

    public int getFailed() {

        return failed;
    }

}
