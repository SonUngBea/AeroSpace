package com.aerospace.domain.configuration;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * Created by coupang on 2017. 8. 23..
 */
public class CustomHttpMessageConverter extends AbstractHttpMessageConverter<String> {

	CustomHttpMessageConverter(){
		System.out.println("httpMessageConverter");
	}

	protected boolean supports(Class<?> clazz) {
		return false;
	}

	protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

	}
}
