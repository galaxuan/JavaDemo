package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: App配置
 * @author: wang gang
 * @create: 2019-03-12 15:13
 * 加载启动类
 */
@Component
@ConfigurationProperties(prefix="app")
public class AppConfig {
    private String name;
    private String description;
    private String version;
    private Integer pageSize;
    private Boolean showAdvert;
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getShowAdvert() {
        return showAdvert;
    }

    public void setShowAdvert(Boolean showAdvert) {
        this.showAdvert = showAdvert;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}