package com.advanced.training.sample.oauth.grant.type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.model.AuthenticatedUser;
import org.wso2.carbon.identity.oauth2.IdentityOAuth2Exception;
import org.wso2.carbon.identity.oauth2.ResponseHeader;
import org.wso2.carbon.identity.oauth2.dto.OAuth2AccessTokenRespDTO;
import org.wso2.carbon.identity.oauth2.model.RequestParameter;
import org.wso2.carbon.identity.oauth2.token.OAuthTokenReqMessageContext;
import org.wso2.carbon.identity.oauth2.token.handlers.grant.AbstractAuthorizationGrantHandler;
import org.wso2.carbon.utils.multitenancy.MultitenantUtils;

import java.util.UUID;

public class CustomOauthGrant extends AbstractAuthorizationGrantHandler {

    private static Log log = LogFactory.getLog(CustomOauthGrant.class);


    public static final String MOBILE_GRANT_PARAM = "mobileNumber";

    @Override
    public boolean validateGrant(OAuthTokenReqMessageContext oAuthTokenReqMessageContext)  throws IdentityOAuth2Exception {

        log.info("Mobile Grant handler is hit");

        //add code here
        return true;
    }

    @Override
    public OAuth2AccessTokenRespDTO issue(OAuthTokenReqMessageContext tokReqMsgCtx) throws IdentityOAuth2Exception {

        //add code here
        return null;
    }

    public boolean authorizeAccessDelegation(OAuthTokenReqMessageContext tokReqMsgCtx)
            throws IdentityOAuth2Exception {

        //add code here
        return true;

    }


    public boolean validateScope(OAuthTokenReqMessageContext tokReqMsgCtx)
            throws IdentityOAuth2Exception {

        //add code here
        return true;
    }

    @Override
    public boolean isOfTypeApplicationUser() throws IdentityOAuth2Exception {

        //add code here
        return true;
    }

}