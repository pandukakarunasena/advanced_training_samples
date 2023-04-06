package com.advanced.training.sample.event.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.base.IdentityRuntimeException;
import org.wso2.carbon.identity.core.bean.context.MessageContext;
import org.wso2.carbon.identity.core.handler.InitConfig;
import org.wso2.carbon.identity.event.IdentityEventConstants;
import org.wso2.carbon.identity.event.event.Event;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;

public class CustomEventHandler extends AbstractEventHandler {

    private static final Log log = LogFactory.getLog(CustomEventHandler.class);

    @Override
    public String getName() {

        return "customEventHandler";
    }

    public void handleEvent(Event event) {

        if (IdentityEventConstants.Event.PRE_ADD_USER.equals(event.getEventName())) {
            String tenantDomain = (String) event.getEventProperties().get(
                    IdentityEventConstants.EventProperty.TENANT_DOMAIN);
            String username = (String) event.getEventProperties().get(IdentityEventConstants.EventProperty.USER_NAME);
            log.info("Handling the event before adding user: " + username + " in tenant domain: " + tenantDomain);
            // You can write any code here to handle the event.
        }

        if (IdentityEventConstants.Event.POST_ADD_USER.equals(event.getEventName())) {
            String tenantDomain = (String) event.getEventProperties()
                    .get(IdentityEventConstants.EventProperty.TENANT_DOMAIN);
            String userName = (String) event.getEventProperties().get(IdentityEventConstants.EventProperty.USER_NAME);
            log.info("Handling the event after adding user: " + userName + " in tenant domain: " + tenantDomain);
            // You can write any code here to handle the event.
        }
    }

    @Override
    public void init(InitConfig configuration) throws IdentityRuntimeException {

        super.init(configuration);
    }

    @Override
    public int getPriority(MessageContext messageContext) {

        return 250;
    }
}
