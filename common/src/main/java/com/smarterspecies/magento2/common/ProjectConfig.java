package com.smarterspecies.magento2.common;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config{

    String host();
}
