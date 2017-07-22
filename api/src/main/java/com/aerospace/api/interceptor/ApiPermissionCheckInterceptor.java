package com.aerospace.api.interceptor;

import com.aerospace.api.annotations.ApiPermission;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * Created by coupang on 2017. 7. 19..
 */

public class ApiPermissionCheckInterceptor extends HandlerInterceptorAdapter {
	private static final String API_PERMISSION_KEY = "eyyrh-33jfj-dhhhf";

	public ApiPermissionCheckInterceptor() {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Annotation[] annotations = handler.getClass().getAnnotations();

		for (Annotation annotation : annotations) {
			if (annotation instanceof ApiPermission) {
				return this.isValidApiPermissionKey(this.getApiPermissionKeyFromRequest(request));
			}
		}

		return true;
	}

	private String getApiPermissionKeyFromRequest(HttpServletRequest request) {
		return request.getHeader("API-AUTH");
	}

	private boolean isValidApiPermissionKey(String key) {
		return StringUtils.equalsIgnoreCase("eyyrh-33jfj-dhhhf", key);
	}
}