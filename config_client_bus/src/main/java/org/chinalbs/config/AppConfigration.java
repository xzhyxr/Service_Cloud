package org.chinalbs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
//@RefreshScope
public class AppConfigration {

//	@Value("${url}")
//	private String url;
//	
//	@Value("${userName}")
//	private String userName;
//	
//	@Value("${passWord}")
//	private String passWord;
//	
//	@Value("${driverClass:com.mysql.jdbc.Driver}")
//	private String driverClass;
//	
//	@Bean
//	@RefreshScope
//	public DataSource dataSource()
//	{
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(passWord);
//		return dataSource;
//	}
	
	@Bean
	@RefreshScope
	public DataSource dataSource(@Value("${url}") String url, @Value("${userName}") String userName, 
			@Value("${passWord}") String passWord, @Value("${driverClass:com.mysql.jdbc.Driver}") String driverClass)
	{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
		return dataSource;
	}
}
