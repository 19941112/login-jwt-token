/* ***************************************************************************
 * Copyright 2022 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * ***************************************************************************
 * $Author$ $Id$ $DateTime$
 * ***************************************************************************/

package com.java.login.jwt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class ResourseConfig {
	
	
	/*
	 * @Bean(name = "db1")
	 * 
	 * @ConfigurationProperties(prefix = "spring.datasource") public DataSource
	 * dataSource1() { return DataSourceBuilder.create().build(); }
	 * 
	 * @Bean(name = "jdbcTemplate1") public NamedParameterJdbcTemplate
	 * jdbcTemplate1(@Qualifier("db1") DataSource ds) { return new
	 * NamedParameterJdbcTemplate(ds); }
	 */

}
