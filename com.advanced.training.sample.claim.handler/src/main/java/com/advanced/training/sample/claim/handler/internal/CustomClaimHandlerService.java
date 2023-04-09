package com.advanced.training.sample.claim.handler.internal;

import com.advanced.training.sample.claim.handler.CustomClaimHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;
import org.wso2.carbon.identity.application.authentication.framework.handler.claims.ClaimHandler;

@Component(
        name = "custom.claim.handler.component",
        immediate = true)
public class CustomClaimHandlerService {

    private static Log log = LogFactory.getLog(CustomClaimHandlerService.class);

    @Activate
    protected void activate(ComponentContext context) {
        try {
            BundleContext bundleContext = context.getBundleContext();
            bundleContext.registerService(ClaimHandler.class.getName(), new CustomClaimHandler(),
                    null);
            log.info("Custom claim handler handler component activated successfully.");
        } catch (Exception e) {
            log.error("Error while activating custom claim handler handler handler component.", e);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {
        if (log.isDebugEnabled()) {
            log.debug("Custom claim handler is de-activated");
        }
    }
}
