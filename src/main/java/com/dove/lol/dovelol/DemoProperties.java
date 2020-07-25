package com.dove.lol.dovelol;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Dovelol
 * @date 2020/7/23 21:40
 */
@ConfigurationProperties("dovelol")
public class DemoProperties {

    private String demoName;

    private String demoMessage;

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public String getDemoMessage() {
        return demoMessage;
    }

    public void setDemoMessage(String demoMessage) {
        this.demoMessage = demoMessage;
    }
}
