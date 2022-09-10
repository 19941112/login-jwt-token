package com.java.login.jwt.daoimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.login.jwt.bo.BlogData;
import com.java.login.jwt.bo.ResponseData;
import com.java.login.jwt.dao.ReadDAO;
import com.java.login.jwt.mapper.ResponseBlogDataMapper;
import com.java.login.jwt.mapper.ResponseDataMapper;
import com.java.login.jwt.sql.SqlQuery;

@Repository
public class ReadDaoImpl implements ReadDAO{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<ResponseData> read() {
		List<ResponseData> result = jdbcTemplate.query(SqlQuery.GET_DATA, new ResponseDataMapper());		 
		return result;
	}
	
	@Override
	public Boolean publish(BlogData data){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		try {
		
		params.addValue("postname",data.getPostname());
		params.addValue("shortdesc",data.getShortdescription());
		params.addValue("postcontent",data.getPostcontent());
		params.addValue("publishdate",data.getPublishdate());
		params.addValue("fullname", data.getFullname());
		params.addValue("email",data.getEmail());
		params.addValue("category",data.getSelectcategory());
		params.addValue("contributors",data.getContributors());
		params.addValue("status",data.getRecordstatus());
		}
		
		catch(DataAccessException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		int status = jdbcTemplate.update(SqlQuery.PUBLISH_DATA, params);	
		System.out.println(status);
		return true;
	}

	@Override
	public List<BlogData> readblog() {
		List<BlogData> result = jdbcTemplate.query(SqlQuery.READ_DATA, new ResponseBlogDataMapper());		 
		return result;
	}

	@Override
	public Boolean deleteblog(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("id", id) ;
		int result = jdbcTemplate.update(SqlQuery.DELETE_DATA, params);		 
		return result>0;
	}

	@Override
	public Boolean updateblog(BlogData data, int id) {
    
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		try {
		
		params.addValue("postname",data.getPostname());
		params.addValue("shortdesc",data.getShortdescription());
		params.addValue("postcontent",data.getPostcontent());
		params.addValue("publishddate",data.getPublishdate());
		params.addValue("fullname", data.getFullname());
		params.addValue("email",data.getEmail());
		params.addValue("category",data.getSelectcategory());
		params.addValue("contributors",data.getContributors());
		params.addValue("status",data.getRecordstatus());
		params.addValue("id", id);
		}
		
		catch(DataAccessException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		int status = jdbcTemplate.update(SqlQuery.UPDATE_DATA, params);	
		System.out.println(status);
		if(status == 1)
		return true;
		else
			return false ;
	}

}

