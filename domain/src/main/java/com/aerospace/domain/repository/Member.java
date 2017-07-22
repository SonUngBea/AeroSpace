package com.aerospace.domain.repository;

import lombok.Data;

import java.util.Date;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Data
public class Member {
	private String memberSeq;
	private String email;
	private String password;
	private String name;

	private Date createdAt;
	private Date modifiedAt;
}


