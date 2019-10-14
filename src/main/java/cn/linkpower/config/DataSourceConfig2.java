package cn.linkpower.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.xa.DruidXADataSource;

import cn.linkpower.config.po.DBConfig2;

/**
 * 第二个数据源配置 --- 不配置事务
 * @author 76519
 *
 */
@Configuration
@MapperScan(basePackages="cn.linkpower.dao.mapper2",sqlSessionFactoryRef="sqlSessionFactory2")
public class DataSourceConfig2 {
	
	@Bean(name="dataSource2")
    public DataSource dataSource1(DBConfig2 dbConfig2) throws Exception {
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl(dbConfig2.getUrl());
        druidXADataSource.setUsername(dbConfig2.getUsername());
        druidXADataSource.setPassword(dbConfig2.getPassword());
 
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("dataSource2");
        atomikosDataSourceBean.setPoolSize(5);
        
//        atomikosDataSourceBean.setMinPoolSize(3);
//        atomikosDataSourceBean.setMaxPoolSize(20);
//        atomikosDataSourceBean.setMaxLifetime(20000);
//        atomikosDataSourceBean.setBorrowConnectionTimeout(30);
//        atomikosDataSourceBean.setLoginTimeout(30);
//        atomikosDataSourceBean.setMaintenanceInterval(60);
//        atomikosDataSourceBean.setMaxIdleTime(60);
//        atomikosDataSourceBean.setTestQuery("select 1");
 
        return atomikosDataSourceBean;
    }
	
	@Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("dataSource2") DataSource masterDataSource)
        throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/bunana1/*Mapper.xml"));
        return sessionFactory.getObject();
    }
}
