package com.felix.common.util;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 
 * @author felix
 *
 */
public class MessageSourceUtils {

	private static final Logger logger = LoggerFactory.getLogger(MessageSourceUtils.class);

	public static String getMessage(String key, Object[] params) {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setCacheSeconds(-1);
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
		messageSource.setBasenames("i18n/messages", "exception/messages");

		String message = "";
		try {
			Locale locale = LocaleContextHolder.getLocale();
			message = messageSource.getMessage(key, params, locale);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return message;
	}
}
