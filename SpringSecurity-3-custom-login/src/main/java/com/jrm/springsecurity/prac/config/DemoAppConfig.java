package com.jrm.springsecurity.prac.config;



import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = " com.jrm.springsecurity.prac")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
    //define bean for view resolver

	@Autowired
	private Environment env;
	
	//setup logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    
    
    //define bean for security data source
    
    @Bean
    public DataSource securityDataSource() {
    	//create connection pool
    	
    	ComboPooledDataSource securityDataSourcevar = new ComboPooledDataSource();
    	
    	//set jdbc driver
    	
    	try {
			securityDataSourcevar.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
    	
    	// log connection props
    	logger.info(">> jdc.url="+env.getProperty("jdbc.url"));
    	logger.info(">> jdc.url="+env.getProperty("jdbc.user"));
    	//set database connection props
    	
    	securityDataSourcevar.setJdbcUrl(env.getProperty("jdbc.url"));
    	securityDataSourcevar.setUser(env.getProperty("jdbc.user"));
    	securityDataSourcevar.setPassword(env.getProperty("jdbc.url"));
    	
    	
    	//set connection pool source
    	
    	securityDataSourcevar.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    	securityDataSourcevar.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    	securityDataSourcevar.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    	securityDataSourcevar.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
    	
    	return securityDataSourcevar;
    }
    
    
    //read environment property and convert it to int
    
    private int getIntProperty(String propName)
    {
    	String propValString = env.getProperty(propName);
    	
    	int intPropVal = Integer.parseInt(propValString);
    	
    	
    	return intPropVal;
    }
}


