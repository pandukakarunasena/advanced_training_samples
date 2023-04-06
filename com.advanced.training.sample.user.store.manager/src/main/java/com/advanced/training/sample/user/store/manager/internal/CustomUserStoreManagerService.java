package com.advanced.training.sample.user.store.manager.internal;

import com.advanced.training.sample.user.store.manager.CustomUserStoreManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.user.api.UserStoreManager;
import org.wso2.carbon.user.core.service.RealmService;


/**
 * Custom User Store Manager Component
 */
@Component(name = "custom.jdbc.user.store.manager.component",
        immediate = true)
public class CustomUserStoreManagerService {

    private static Log log = LogFactory.getLog(CustomUserStoreManagerService.class);
    private static RealmService realmService;

    @Activate
    protected void activate(ComponentContext ctxt) {

        try {
            UserStoreManager customUserStoreManager = new CustomUserStoreManager();
            ctxt.getBundleContext().registerService(UserStoreManager.class.getName(),
                    customUserStoreManager, null);
            log.info("Custom user store is activated successfully..");
        } catch (Throwable e) {
            log.info("Error while activating custom user store bundle");
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext ctxt) {

        if (log.isDebugEnabled()) {
            log.debug("Custom user store Manager is deactivated ");
        }
    }

    @Reference(
            name = "RealmService",
            service = org.wso2.carbon.user.core.service.RealmService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetRealmService")

    protected void setRealmService(RealmService rlmService) {

        realmService = rlmService;
    }

    protected void unsetRealmService(RealmService realmService) {

        realmService = null;
    }
}
