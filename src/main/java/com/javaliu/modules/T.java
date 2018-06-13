package com.javaliu.modules;

import java.time.*;
import java.util.Locale;

/**
 * <br> 类名：T
 * <br> 描述：
 * <br> 作者：sontek
 * <br> 创建：2018年06月07日
 * <br> 版本：V1.0.0
 */
public class T {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(ZoneId.systemDefault().toString());
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println(zonedDateTime);
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant instant1 = Instant.parse("2018-06-13T01:21:47.999Z");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant1, ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime);
    }
}
