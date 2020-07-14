package com.purcotton.omni.promotion.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration
{

	@Value(value="${hikari-jdbc-url}")
	private String hikariJdbcUrl="";
	@Value(value="${hikari-jdbc-password}")
	private String hikariJdbcPassword;
	@Value(value="${hikari-jdbc-username}")
	private String hikariJdbcUsername;
	@Value(value="${hikari-jdbc-driver-class-name}")
	private String hikariJdbcDriverClassName;

	// Hikari 连接池
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(hikariJdbcUrl);
		ds.setUsername(hikariJdbcUsername);
		ds.setPassword(hikariJdbcPassword);
		ds.setDriverClassName(hikariJdbcDriverClassName);
		return ds;
	}

	@Bean
	public DataSourceTransactionManager dbTransactionManager(DataSource DataSource) {
		return new DataSourceTransactionManager(DataSource);
	}


	@Bean
	public SqlSessionFactory dbSqlSessionFactory(DataSource DataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(DataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath*:/mapper/*.xml"));
		sessionFactory.setTransactionFactory(new SpringManagedTransactionFactory());
		return sessionFactory.getObject();
	}
}
