package com.wpt.risk.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource({"classpath:appConfig.properties", "classpath:appConfig-${spring.profiles.active}.properties"})
@ConfigurationProperties(prefix = "phoenix")
@Profile(value = {"dev", "production"})
@MapperScan(value = "com.wpt.risk.dal.phoenixdao", sqlSessionFactoryRef = "phoenixSqlSessionFactory")
@EnableTransactionManagement
public class PhoenixDsConfig {

    @Autowired
    private Environment environment;

    private String connectionUrl;
    private String driverName;

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Bean("phoenixDataSource")
    @Qualifier("phoenixDataSource")
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(connectionUrl);
        dataSource.setDriverClassName(driverName);
        dataSource.setConnectProperties(new Properties() {{
            put("phoenix.schema.isNamespaceMappingEnabled", "true");
        }});
        return dataSource;
    }

    @Bean("phoenixSqlSessionFactory")
    @Qualifier("phoenixSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("phoenixDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/com/wpt/risk/dal/phoenixMapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(environment.getProperty("mybatis.config-location")));

        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "hsqldb");
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("reasonable", "true");
        interceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{interceptor});

        return sqlSessionFactoryBean.getObject();
    }

    @Bean("phoenixPlatformTransactionManager")
    @Qualifier("phoenixPlatformTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("phoenixDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}