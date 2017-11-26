/** 
* @author  mo
* @date 创建时间：2017年11月26日 上午12:24:09 
* @version 1.0 
* @return  
*/

package org.mo.config.db;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/** 
* @author  mo
* @date 创建时间：2017年11月26日 上午12:24:09 
* @version 1.0 
* @return  
*/
@Configuration
@MapperScan(basePackages = "org.mo.user.mapper.primary", sqlSessionTemplateRef  = "primarySessionTemplate")
public class DataSourceConfig1 {
	
	@Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
	@Primary
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "primarySessionFactory")
    @Primary
	public SqlSessionFactory primarySessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/primary/*.xml"));
		return bean.getObject();
	}
	
	@Bean(name = "primaryTransactionManager")
	@Primary
	public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name = "primarySessionTemplate")
	@Primary
	public SqlSessionTemplate primarySessionTemplate(@Qualifier("primarySessionFactory") SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
