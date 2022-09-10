package com.java.login.jwt.sql;


public class SqlQuery {

	public static final String GET_DATA ="select * from user_post order by created_datetime desc limit 10";

	public static final String PUBLISH_DATA = "INSERT INTO postblog.blog\r\n" + "(postname,\r\n" + "shortdesc,\r\n"
			+ "postcontent,\r\n" + "publishddate,\r\n" + "fullname,\r\n" + "email,\r\n" + "category,\r\n"
			+ "contributors,\r\n" + "status)\r\n" + "VALUES\r\n" + "(:postname,\r\n" + ":shortdesc,\r\n"
			+ ":postcontent,\r\n" + ":publishdate,\r\n" + ":fullname,\r\n" + ":email,\r\n" + ":category,\r\n"
			+ ":contributors,\r\n" + ":status);\r\n" + "";

	public static final String READ_DATA = "select * from postblog.blog where deleted=0";

	public static final String DELETE_DATA = "UPDATE postblog.blog\r\n"
			+ "	SET deleted = \"1\" WHERE postid=:id";
	
	public static final String UPDATE_DATA = "UPDATE postblog.blog\r\n" + "SET\r\n" + "postname = :postname,\r\n"
			+ "shortdesc = :shortdesc,\r\n" + "postcontent = :postcontent,\r\n" + "publishddate = :publishddate,\r\n"
			+ "fullname = :fullname,\r\n" + "email = :email,\r\n" + "category = :category,\r\n"
			+ "contributors = :contributors,\r\n" + "status = :status \r\n" + "WHERE postid = :id \r\n" + "";


}
