package com.oracle.stcdc.racgroup.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.oracle.stcdc.racgroup.mapper.bugdb", sqlSessionFactoryRef = "bugdbSqlSessionFactory")
public class DataSourceBugdb {

    @Bean(name = "bugdbDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.bugdb")
    public DataSource getDataSourceBugDB(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "bugdbSqlSessionFactory")
    public SqlSessionFactory bugdbSqlSessionFactory(@Qualifier("bugdbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlbean = new SqlSessionFactoryBean();
        sqlbean.setDataSource(dataSource);
        sqlbean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResource("classpath:/mapper/bugdb/bugdbMapper.xml")
        );
        return sqlbean.getObject();
    }

    @Primary
    @Bean(name = "bugdbSqlSessionTemplate")
    public SqlSessionTemplate bugdbSqlSessionTemplate(@Qualifier("bugdbSqlSessionFactory") SqlSessionFactory sqlSessionFactory ){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
