package com.springbootrestapp.resource.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/i18n")
public class HelloUseri18nResource {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	public String greetUser() {
		String greetingMessage = messageSource.getMessage("greeting", null, Locale.US);
		return greetingMessage;
	}
	
	@GetMapping("/header")
	public String greetUserWithRequestHeader(@RequestHeader(value = "Accept-Language", defaultValue = "us") Locale locale) {
		String greetingMessage = messageSource.getMessage("greeting", null, locale);
		return greetingMessage;
	}
	
	@GetMapping("/nonheader")
	public String greetUserWithoutRequestHeaderAnnotation() {
		Locale locale = LocaleContextHolder.getLocale();
		String greetingMessage = messageSource.getMessage("greeting", null, locale);
		return greetingMessage;
	}
	
}
