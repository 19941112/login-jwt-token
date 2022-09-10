package com.java.login.jwt.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.java.login.jwt.bo.BlogData;

public class ResponseBlogDataMapper implements RowMapper<BlogData>{

	@Override
	public BlogData mapRow(ResultSet rs, int rowNum)throws SQLException{
		BlogData response = new BlogData();
		response.setPostname(rs.getString("postname"));
		response.setShortdescription(rs.getString("shortdesc"));
		response.setPostcontent(rs.getString("postcontent"));
		response.setFullname(rs.getString("fullname"));
		response.setEmail(rs.getString("email"));
		response.setPublishdate(rs.getDate("publishddate"));
		response.setSelectcategory(rs.getString("category"));
		response.setRecordstatus(rs.getString("status"));
		response.setContributors(rs.getString("contributors"));
		
		return response;
	}

}
