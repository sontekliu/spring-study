package com.javaliu.modules.i18n;

import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <br> 类名：TimeZoneController
 * <br> 描述：
 * <br> 作者：sontek
 * <br> 创建：2018年06月13日
 * <br> 版本：V1.0.0
 */
@RequestMapping(value = "/timeZone/")
@Controller
public class TimeZoneController {

    @RequestMapping("tzHandler")
    public String handle() {
        return "modules/i18n/timeZone.html";
    }

    @RequestMapping(value = "tzValueHandler", method = RequestMethod.POST)
    public String handleTzValue(
            Locale locale, HttpServletRequest req,
            HttpServletResponse res,
            @RequestParam("requestedUrl") String requestedUrl,
            @RequestParam("timeZoneOffset") int timeZoneOffset) {

        ZoneOffset zoneOffset =
                ZoneOffset.ofTotalSeconds(-timeZoneOffset * 60);

        TimeZone timeZone = TimeZone.getTimeZone(zoneOffset);

        LocaleContextResolver localeResolver =
                (LocaleContextResolver) RequestContextUtils.getLocaleResolver(req);

        localeResolver.setLocaleContext(req, res,
                new SimpleTimeZoneAwareLocaleContext(
                        locale, timeZone));

        return "redirect:" + requestedUrl;

    }

    @RequestMapping("index")
    @ResponseBody
    public String testHandler(Locale clientLocale, ZoneId clientZoneId) {

        ZoneOffset serverZoneOffset = ZoneOffset.ofTotalSeconds(
                TimeZone.getDefault().getRawOffset() / 1000);

        return String.format("client timeZone: %s" +
                        "<br/> " +
                        "server timeZone: %s" +
                        "<br/>" +
                        " locale: %s%n",
                clientZoneId.normalized().getId(),
                serverZoneOffset.getId(),
                clientLocale);
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        TimeZone timeZone = RequestContextUtils.getTimeZone(request);
        System.out.println(timeZone);

        return "aaa" + timeZone.toZoneId() + "当前时间是：" + LocalDateTime.ofInstant(Instant.now(), timeZone.toZoneId());
    }
}
