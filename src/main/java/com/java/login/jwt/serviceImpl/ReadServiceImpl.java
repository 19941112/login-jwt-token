package com.java.login.jwt.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.login.jwt.bo.BlogData;
import com.java.login.jwt.bo.ResponseData;
import com.java.login.jwt.dao.ReadDAO;
import com.java.login.jwt.service.ReadService;

@Service
public class ReadServiceImpl implements ReadService{

	@Autowired
	ReadDAO readDao;
	
	@Override
	public List<ResponseData> read() {
		
		return readDao.read();
	}
	
	@Override
	public Boolean publish(BlogData data) {
		Boolean status = readDao.publish(data);
		return status;
		
	}

	@Override
	public List<BlogData> readblog() {
		return readDao.readblog();
	}

	@Override
	public Boolean deleteblog(int id) {
		return readDao.deleteblog(id);
	}

	@Override
	public Boolean updateblog(BlogData data, int id) {
		Boolean status = readDao.updateblog(data,id);
		return status;
	}

}
