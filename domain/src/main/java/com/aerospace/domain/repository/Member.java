package com.aerospace.domain.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Entity
@Data
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "memberSeq")
	private Integer memberSeq;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "modifiedAt")
	private Date modifiedAt;

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
		modifiedAt = new Date();
	}

	@PostPersist
	public void postPersist() {
		modifiedAt = new Date();
	}
}


