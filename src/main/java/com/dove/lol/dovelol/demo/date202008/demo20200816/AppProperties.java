package com.dove.lol.dovelol.demo.date202008.demo20200816;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Dovelol
 * @date 2020/8/16 11:56
 */
@ConfigurationProperties(prefix = "app")
@PropertySource("classpath:META-INF/app.properties")
public class AppProperties {

    private String version;

    private String name;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
