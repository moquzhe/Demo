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
@MapperScan(basePackages = "org.mo.user.mapper.secondary", sqlSessionTemplateRef  = "secondarySessionTemplate")
public class DataSourceConfig2 {
	
	@Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "secondarySessionFactory")
	public SqlSessionFactory secondarySessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/secondary/*.xml"));
		return bean.getObject();
	}
	
	@Bean(name = "secondaryTransactionManager")
	public DataSourceTransactionManager secondaryTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name = "secondarySessionTemplate")
	public SqlSessionTemplate secondarySessionTemplate(@Qualifier("secondarySessionFactory") SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
