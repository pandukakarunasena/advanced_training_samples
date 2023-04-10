package com.advanced.training.sample.outbound.provisioning.connector.internal;

import com.advanced.training.sample.outbound.provisioning.connector.CustomOutboundProvisioningConnectorFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;


@Component(
        name = "identity.outbound.provisioning.sample.component",
        immediate = true
)
public class CustomOutboundProvisioningConnectorService {

    private static Log LOG = LogFactory.getLog(CustomOutboundProvisioningConnectorService.class);

    @Activate
    protected void activate(ComponentContext context) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Activating SampleConnectorServiceComponent");
        }
        try {
            CustomOutboundProvisioningConnectorFactory provisioningConnectorFactory = new
                    CustomOutboundProvisioningConnectorFactory();
            context.getBundleContext().registerService(AbstractProvisioningConnectorFactory.class.getName(),
                    provisioningConnectorFactory, null);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Sample Outbound Provisioning Connector bundle is activated");
            }
        } catch (Throwable e) {
            LOG.error("Error while activating Sample Identity Provisioning Connector ", e);
        }
    }
}
