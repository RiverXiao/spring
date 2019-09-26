package com.oracle.stcdc.racgroup.dataSource;

import com.oracle.stcdc.racgroup.mapper.raccdcpdb.ClusterMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
//@MapperScan(basePackages = "com.oracle.stcdc.racgroup.mapper.raccdcpdb",sqlSessionFactoryRef = "raccdcSqlSessionFactory")
@MapperScan(basePackageClasses = ClusterMapper.class,sqlSessionFactoryRef = "raccdcSqlSessionFactory")
public class DataSourceRaccdc {

    @Bean(name = "raccdcDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.raccdc")
    public DataSource getDataSourceBugDB(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "raccdcSqlSessionFactory")
    public SqlSessionFactory bugdbSqlSessionFactory(@Qualifier("raccdcDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlbean = new SqlSessionFactoryBean();
        sqlbean.setDataSource(dataSource);
        sqlbean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResource("classpath:/mapper/raccdcpdb/clusterMapper.xml")
        );
        return sqlbean.getObject();
    }


    @Bean(name = "raccdcSqlSessionTemplate")
    public SqlSessionTemplate bugdbSqlSessionTemplate(@Qualifier("raccdcSqlSessionFactory") SqlSessionFactory sqlSessionFactory ){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

