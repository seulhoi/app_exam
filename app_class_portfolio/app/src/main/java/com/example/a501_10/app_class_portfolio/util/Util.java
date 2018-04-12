package com.example.a501_10.app_class_portfolio.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by 501-10 on 2018-04-10.
 */

public class Util {
    public static Date getNowDateTime() {
     /*   return Date.from(
                LocalDateTime.now()
                .atZone(ZoneId.systemDefault()).toInstant());
*/
     return new Date();
    }
}
