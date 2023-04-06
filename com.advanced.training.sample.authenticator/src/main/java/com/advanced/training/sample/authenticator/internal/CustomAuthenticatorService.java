package com.advanced.training.sample.authenticator.internal;

import com.advanced.training.sample.authenticator.CustomAuthenticator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import org.wso2.carbon.user.core.service.RealmService;

@Component(
        name = "custom.local.auth.component",
        immediate = true)
public class CustomAuthenticatorService {

    private static Log log = LogFactory.getLog(CustomAuthenticatorService.class);

    private static RealmService realmService;

    @Activate
    protected void activate(ComponentContext ctxt) {

        try {
            CustomAuthenticator customAuthenticator = new CustomAuthenticator();
            ctxt.getBundleContext().registerService(ApplicationAuthenticator.class.getName(),
                    customAuthenticator, null);
            log.info("custom local authenticator bundle is activated");
        } catch (Throwable e) {
            log.error("custom local authenticator bundle activation failed.", e);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext ctxt) {

        if (log.isDebugEnabled()) {
            log.debug("customAuthenticator bundle is deactivated");
        }
    }

    public static RealmService getRealmService() {

        return realmService;
    }

    @Reference(name = "realm.service",
            service = org.wso2.carbon.user.core.service.RealmService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetRealmService")
    protected void setRealmService(RealmService realmService) {

        if (log.isDebugEnabled()) {
            log.debug("Setting the Realm Service");
        }
        CustomAuthenticatorService.realmService = realmService;
    }

    protected void unsetRealmService(RealmService realmService) {

        if (log.isDebugEnabled()) {
            log.debug("UnSetting the Realm Service");
        }
        CustomAuthenticatorService.realmService = null;
    }
}
