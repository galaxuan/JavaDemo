package com.springbootdatajpa;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: wanggang
 * @date: 2019-3-25
 */
@SpringBootApplication
public class Application {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        //创建StatViewServlet，绑定到/druid/*路径下
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> param = new HashMap<>();
        param.put("loginUsername", "admin");
        param.put("loginPassword", "admin");
        param.put("allow", "");
        param.put("deny", "");
        bean.setInitParameters(param);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //设置过滤器
        bean.setFilter(new WebStatFilter());
        bean.addUrlPatterns("/*");
        Map<String, String> param = new HashMap<>();
        param.put("exclusions", "*png,*.woff,*.js,*.css,/druid/*");
        bean.setInitParameters(param);
        return bean;
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
