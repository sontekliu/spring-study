package com.javaliu.modules.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

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
    public String index(HttpServletRequest request){
        Locale requestLocale = request.getLocale();
/*        Locale sessionLocale = (Locale)request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        System.out.println(sessionLocale.getCountry());
        System.out.println(sessionLocale.getDisplayLanguage());*/
        logger.debug("debugdebugdebugdebugdebugdebugdebugdebugdebugdebug");
        logger.info("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        logger.warn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        logger.error("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        Locale locale11 = LocaleContextHolder.getLocale();
        Locale locale = RequestContextUtils.getLocale(request);
        String str = messageSource.getMessage("hello", null, locale);
        System.out.println(str);
        return "modules/i18n/index";
    }
}
