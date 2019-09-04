package com.ucss.elementary.tnwn.config.datasource;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.ucss.elementary.tnwn.mapper.tnwn"}, sqlSessionFactoryRef = "sqlSessionFactoryTnwn")
public class MybatisDbConfigTnwn {

    private String xmlLocation = "classpath:mybatis/mapper/tnwn/*.xml";

    @Autowired
    @Qualifier("datasourceTnwn")
    private DataSource dataSource;

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryTnwn() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(xmlLocation));
        Interceptor[] plugins = new Interceptor[]{new PageHelper()};
        factoryBean.setPlugins(plugins);
        return factoryBean.getObject();

    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplatetnwn() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTnwn()); // 使用上面配置的Factory
        return template;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManagertnwn(@Qualifier("datasourceTnwn") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }
}
