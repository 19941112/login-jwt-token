package com.java.login.jwt.bo;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseData {

	private int postId;
	private int profileId;
	private String description;
	private String postLocation;
	private Date createDate;
	private String recordStatus;
	private Date postEndDate;

}
