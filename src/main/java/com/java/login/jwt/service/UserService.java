package com.java.login.jwt.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	private final String FETCH_SQL_BY_ID = "select * from users where username = :username";
	
	@Autowired
	//@Qualifier("jdbcTemplate1")//added
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Logic to get the user form the Database
    	
    	Map parameters = new HashMap();
		parameters.put("username", username);
    	
    	com.java.login.jwt.model.User e =  (com.java.login.jwt.model.User) namedParameterJdbcTemplate.queryForObject(FETCH_SQL_BY_ID, parameters, new UserMapper());

        return new User(e.getUserName(),e.getPassword(),new ArrayList<>());
        
        
    }
}

class UserMapper implements RowMapper {

	
	@Override
	public com.java.login.jwt.model.User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		com.java.login.jwt.model.User user = new com.java.login.jwt.model.User();
		user.setId(rs.getInt("Id"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		
		return user;
	}

}
