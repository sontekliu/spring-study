package com.javaliu.modules.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <br> 类名：I18nController
 * <br> 描述：
 * <br> 作者：javaliu
 * <br> 创建：2018年06月07日
 * <br> 版本：V1.0.0
 */
@Controller
@RequestMapping(value = "/i18n/")
public class I18nController {

    private static final Logger logger = LoggerFactory.getLogger(I18nController.class);

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request) {
        Locale requestLocale = request.getLocale();
/*        Locale sessionLocale = (Locale)request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        System.out.println(sessionLocale.getCountry());
        System.out.println(sessionLocale.getDisplayLanguage());*/
/*        logger.debug("debugdebugdebugdebugdebugdebugdebugdebugdebugdebug");
        logger.info("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        logger.warn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        logger.error("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");*/
        Locale locale11 = LocaleContextHolder.getLocale();
        Locale locale = RequestContextUtils.getLocale(request);
        String str = messageSource.getMessage("hello", null, locale);
        System.out.println(str);
        return "modules/i18n/index";
    }

    @RequestMapping(value = "changeSessionLanguage")
    public String changeSessionLanguage(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        Locale locale = RequestContextUtils.getLocale(request);
        TimeZone timeZone = RequestContextUtils.getTimeZone(request);
        System.out.println(timeZone);
        System.out.println(locale);
        if ("zh".equals(lang)) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    Locale.CHINA);
        } else if ("en".equals(lang)) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    new Locale("en", "US"));
        } else if ("jp".equals(lang)) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    Locale.JAPAN);
        }
        String currentUTCTime = "2018-06-13T01:21:47.999Z";
        //Instant instant = Instant.now();
        Instant instant = Instant.parse("2018-06-13T01:21:47.999Z");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Tokyo"));
        //System.out.println(localDateTime);
        request.setAttribute("currentDateTime", localDateTime);
        return "modules/i18n/index";
    }

    @RequestMapping(value = "showTimeZone")
    public String showTimeZone(TimeZone timeZone, ZoneId zoneId) {
        System.out.println(timeZone);
        System.out.println(zoneId);
        return "modules/i18n/index";
    }
}
