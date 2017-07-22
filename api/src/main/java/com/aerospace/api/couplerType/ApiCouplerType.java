package com.aerospace.api.couplerType;

/**
 * Created by coupang on 2017. 7. 19..
 */

public class ApiCouplerType {
	private static final String API_VERSION = "v1";

	public ApiCouplerType() {
	}

	public static class Member {
		public static final String MEMBER_API_ROOT = "v1/member";
		public static final String FIND_MEMBER_DTO = "/{memberSeq}";

		public Member() {
		}
	}
}
