package com.local.jsonparser.rsrv.model.biz.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class DateTest {
    public static void main(String[] args) {
        String str = "20230601";
        String str2 = "20230703";
        // LocalDate fomatting test
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate time = LocalDate.parse(str, formatter);
        LocalDate time2 = LocalDate.parse(str2, formatter);
        // LocalDate 기간 내 일자 산출 test
        long date = ChronoUnit.DAYS.between(time, time2);
        LocalDate time3;
        for (long i = 1; i < date + 1; i++) {
            time3 = time.plusDays(i);
            System.out.println(time3);
        }
    }
}
