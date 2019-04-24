package com.demo.config;


import com.demo.utils.YamlUtils;

public class GlobalConfig {

    private AppiumConfig appium;

    public static GlobalConfig load() {
        return YamlUtils.readConfigFromYaml("/config/globalConfig.yaml", GlobalConfig.class);
    }


    public AppiumConfig getAppium() {
        return appium;
    }

}
