package com.advanced.training.sample.authenticator;

import com.advanced.training.sample.authenticator.internal.CustomAuthenticatorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.AbstractApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.LocalApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.config.ConfigurationFacade;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.exception.AuthenticationFailedException;
import org.wso2.carbon.identity.application.authentication.framework.exception.InvalidCredentialsException;
import org.wso2.carbon.identity.application.authentication.framework.model.AuthenticatedUser;
import org.wso2.carbon.identity.application.authentication.framework.util.FrameworkUtils;
import org.wso2.carbon.identity.application.common.model.User;
import org.wso2.carbon.identity.base.IdentityRuntimeException;
import org.wso2.carbon.identity.core.util.IdentityTenantUtil;
import org.wso2.carbon.user.api.UserRealm;
import org.wso2.carbon.user.core.UniqueIDUserStoreManager;
import org.wso2.carbon.user.core.UserCoreConstants;
import org.wso2.carbon.user.core.common.AuthenticationResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * This is the sample local authenticator which will be used to authenticate the user based on the registered telephone
 * number.
 */
public class CustomAuthenticator extends AbstractApplicationAuthenticator implements
        LocalApplicationAuthenticator {

    private static final Log log = LogFactory.getLog(CustomAuthenticator.class);
    private static final String TELEPHONE_CLAIM_URL = "http://wso2.org/claims/telephone";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean canHandle(HttpServletRequest httpServletRequest) {

        //add code here

        return true;
    }

    @Override
    protected void initiateAuthenticationRequest(HttpServletRequest request, HttpServletResponse response,
                                                 AuthenticationContext context) throws AuthenticationFailedException {

       //add code here
    }

    @Override
    protected void processAuthenticationResponse(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, AuthenticationContext authenticationContext) throws AuthenticationFailedException {

        //add code here
    }

    @Override
    public String getContextIdentifier(HttpServletRequest httpServletRequest) {

        //add code here
        return null;
    }

    @Override
    public String getName() {

        //add code here
        return null;
    }

    @Override
    public String getFriendlyName() {

        //add code here
        return null;
    }
}