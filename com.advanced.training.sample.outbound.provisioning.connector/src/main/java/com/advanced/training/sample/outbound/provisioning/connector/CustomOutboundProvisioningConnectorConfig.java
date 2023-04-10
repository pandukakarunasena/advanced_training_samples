package com.advanced.training.sample.outbound.provisioning.connector;

import java.util.Properties;

public class CustomOutboundProvisioningConnectorConfig {

    private Properties configs;

    public CustomOutboundProvisioningConnectorConfig(Properties configs) {
        this.configs = configs;
    }

    public String getValue(String key) {
        return this.configs.getProperty(key);
    }
}
