package com.advanced.training.sample.post.authentication.handler;

import org.wso2.carbon.identity.application.authentication.framework.config.ConfigurationFacade;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.exception.PostAuthenticationFailedException;
import org.wso2.carbon.identity.application.authentication.framework.handler.request.AbstractPostAuthnHandler;
import org.wso2.carbon.identity.application.authentication.framework.handler.request.PostAuthnHandlerFlowStatus;
import org.wso2.carbon.identity.application.authentication.framework.model.AuthenticatedUser;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomPostAuthenticationHandler extends AbstractPostAuthnHandler {

    private String CONSENT_POPPED_UP = "consentPoppedUp";

    @Override
    public PostAuthnHandlerFlowStatus handle(HttpServletRequest httpServletRequest,
                                             HttpServletResponse httpServletResponse,
                                             AuthenticationContext authenticationContext)
            throws PostAuthenticationFailedException {


        //add code here

        return null;
    }

    @Override
    public String getName() {

        //add code here

        return null;
    }

    //add code here
}
