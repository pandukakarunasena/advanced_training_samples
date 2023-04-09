package com.advanced.training.sample.claim.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.config.model.StepConfig;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.exception.FrameworkException;
import org.wso2.carbon.identity.application.authentication.framework.handler.claims.impl.DefaultClaimHandler;

import java.util.HashMap;
import java.util.Map;

public class CustomClaimHandler extends DefaultClaimHandler {

    private static final Log log = LogFactory.getLog(CustomClaimHandler.class);
    private static volatile CustomClaimHandler instance;
    private String connectionURL = null;
    private String userName = null;
    private String password = null;
    private String jdbcDriver = null;
    private String sql = null;


    public static CustomClaimHandler getInstance() {
        if (instance == null) {
            synchronized (CustomClaimHandler.class) {
                if (instance == null) {
                    instance = new CustomClaimHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public Map<String, String> handleClaimMappings(StepConfig stepConfig,
                                                   AuthenticationContext context, Map<String, String> remoteClaims,
                                                   boolean isFederatedClaims) throws FrameworkException {
       //add code here

       return null;
    }

    /**
     * Added method to retrieve claims from external sources. The results will be merged to the local claims when
     * returning the final claim list to be added to the SAML response that is sent back to the SP.
     *
     * @param authenticatedUser : The user for whom we require claim values
     * @return
     */
    private Map<String, String> handleExternalClaims(String authenticatedUser) throws FrameworkException {

       //add code here
       return null;
    }
}
