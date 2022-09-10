package com.java.login.jwt.dao;

import java.util.List;

import com.java.login.jwt.bo.BlogData;
import com.java.login.jwt.bo.ResponseData;

public interface ReadDAO {
	List<ResponseData> read();
	
    Boolean publish(BlogData data);
	
	List<BlogData> readblog();
	
	Boolean deleteblog(int id);
	
	Boolean updateblog(BlogData data,int id);
	

}
