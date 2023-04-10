package com.advanced.training.sample.outbound.provisioning.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates the sample connector factory.
 */
public class CustomOutboundProvisioningConnectorFactory extends AbstractProvisioningConnectorFactory{

    private static final Log LOG = LogFactory.getLog(CustomOutboundProvisioningConnectorFactory.class);
    private static final String CONNECTOR_TYPE = "Sample";

    @Override
    protected AbstractOutboundProvisioningConnector buildConnector(Property[] provisioningProperties) throws
            IdentityProvisioningException {

        CustomOutboundProvisioningConnector connector = new CustomOutboundProvisioningConnector();
        connector.init(provisioningProperties);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Sample provisioning connector created successfully.");
        }
        return connector;
    }

    @Override
    public String getConnectorType() {
        return CONNECTOR_TYPE;
    }

    @Override
    public List<Property> getConfigurationProperties() {

        Property clientId = new Property();
        clientId.setName(CustomOutboundProvisioningConnectorConstants.SAMPLE_CLIENT_ID);
        clientId.setDisplayName("Client ID");
        clientId.setDisplayOrder(1);
        clientId.setRequired(true);

        Property clientSecret = new Property();
        clientSecret.setName(CustomOutboundProvisioningConnectorConstants.SAMPLE_CLIENT_SECRET);
        clientSecret.setDisplayName("Client Secret");
        clientSecret.setConfidential(true);
        clientSecret.setDisplayOrder(2);
        clientSecret.setRequired(true);

        Property username = new Property();
        username.setName(CustomOutboundProvisioningConnectorConstants.SAMPLE_USERNAME);
        username.setDisplayName("Username");
        username.setDescription("Username for the external system");
        username.setDisplayOrder(3);
        username.setRequired(true);

        Property password = new Property();
        password.setName(CustomOutboundProvisioningConnectorConstants.SAMPLE_PASSWORD);
        password.setDisplayName("Password");
        password.setDisplayOrder(4);
        password.setRequired(true);

        List<Property> properties = new ArrayList<>();
        properties.add(clientId);
        properties.add(clientSecret);
        properties.add(username);
        properties.add(password);
        return properties;
    }
}
