package com.example.demo.Util;
import java.util.ArrayList;
import java.util.List;

public class BatchUtil {

    public static <T> List<List<T>> partition(List<T> list, int batchSize){

        List<List<T>> batches = new ArrayList<>();

        for(int i=0;i<list.size();i+=batchSize){

            batches.add(list.subList(i,
                    Math.min(i+batchSize,list.size())));

        }

        return batches;

    }

}