package com.example.springbooti18n.resolver;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class UrlLocaleResolver implements LocaleResolver {
    private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // ==> /SomeContextPath/en/..
        // ==> /SomeContextPath/fr/..
        // ==> /SomeContextPath/WEB-INF/pages/...
        String uri = httpServletRequest.getRequestURI();

        System.out.println("URI=" + uri);

        String prefixEn = httpServletRequest.getServletContext().getContextPath() + "/en/";
        String prefixFr = httpServletRequest.getServletContext().getContextPath() + "/fr/";
        String prefixVi = httpServletRequest.getServletContext().getContextPath() + "/vi/";

        Locale locale = null;

        // English
        if (uri.startsWith(prefixEn)) {
            locale = Locale.ENGLISH;
        }
        // French
        else if (uri.startsWith(prefixFr)) {
            locale = Locale.FRANCE;
        }
        // Vietnamese
        else if (uri.startsWith(prefixVi)) {
            locale = new Locale("vi", "VN");
        }

        if (locale != null) {
            httpServletRequest.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
        }

        if (locale == null) {
            locale = (Locale) httpServletRequest.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
            if (locale == null) {
                locale = Locale.ENGLISH;
            }
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
