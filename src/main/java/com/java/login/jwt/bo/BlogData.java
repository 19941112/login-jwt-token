package com.java.login.jwt.bo;

import java.sql.Date;

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
public class BlogData {
	
	private String postname ;
	private String shortdescription ;
	private String postcontent ;
	private Date publishdate ;
	private String fullname ;
	private String email ;
	private String selectcategory ;
	private String contributors ;
	private String recordstatus ;
	
}
