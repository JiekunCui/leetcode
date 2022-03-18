package com.example.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo7 {

    public static void main(String[] args) throws ParseException {
        String param = "2021-01-01|2022-3-10";

        String[] split = param.split("\\|");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = dateFormat.parse(split[0]);
        Date end = dateFormat.parse(split[1]);

        while (begin.compareTo(  end ) <= 0){


        }

    }
}
