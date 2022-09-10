package com.java.login.jwt.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.java.login.jwt.bo.ResponseData;

@Component
public class ResponseDataMapper implements RowMapper<ResponseData>{

	@Override
	public ResponseData mapRow(ResultSet rs, int rowNum)throws SQLException{
		ResponseData response = new ResponseData();
		response.setPostId(rs.getInt("post_id"));
		response.setProfileId(rs.getInt("profile_id"));
		response.setDescription(rs.getString("Description"));
		response.setPostLocation(rs.getString("post_location"));
		response.setCreateDate(rs.getDate("created_datetime"));
		response.setRecordStatus(rs.getString("record_status"));
		response.setPostEndDate(rs.getDate("post_end_date"));
		return response;
	}

}
