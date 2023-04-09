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

        boolean authStatus = false;

        // extract request parameters
        RequestParameter[] parameters = oAuthTokenReqMessageContext.getOauth2AccessTokenReqDTO().getRequestParameters();

        String mobileNumber = null;

        // find out mobile number
        for(RequestParameter parameter : parameters){
            if(MOBILE_GRANT_PARAM.equals(parameter.getKey())){
                if(parameter.getValue() != null && parameter.getValue().length > 0){
                    mobileNumber = parameter.getValue()[0];
                }
            }
        }

        if(mobileNumber != null) {
            //validate mobile number
            authStatus =  isValidMobileNumber(mobileNumber);

            if(authStatus) {
                // if valid set authorized mobile number as grant user
                String tenantAwareUsername = MultitenantUtils.getTenantAwareUsername(mobileNumber);
                /*
                    Please use AuthenticatedUser.createFederateAuthenticatedUserFromSubjectIdentifier() if a federated
                    user is involved with this custom grant.
                 */
                AuthenticatedUser mobileUser = AuthenticatedUser.createLocalAuthenticatedUserFromSubjectIdentifier(
                        tenantAwareUsername);
                // Set the federated IdP name if a federated user is involved with this custom grant.
                // mobileUser.setFederatedIdPName(FrameworkConstants.LOCAL_IDP_NAME);

                oAuthTokenReqMessageContext.setAuthorizedUser(mobileUser);
                oAuthTokenReqMessageContext.setScope(oAuthTokenReqMessageContext.getOauth2AccessTokenReqDTO().getScope());
            } else{
                ResponseHeader responseHeader = new ResponseHeader();
                responseHeader.setKey("SampleHeader-999");
                responseHeader.setValue("Provided Mobile Number is Invalid.");
                oAuthTokenReqMessageContext.addProperty("RESPONSE_HEADERS", new ResponseHeader[]{responseHeader});
            }

        }

        return authStatus;
    }

    @Override
    public OAuth2AccessTokenRespDTO issue(OAuthTokenReqMessageContext tokReqMsgCtx) throws IdentityOAuth2Exception {

        OAuth2AccessTokenRespDTO tokenRespDTO = new OAuth2AccessTokenRespDTO();
        tokenRespDTO.setExpiresIn(tokReqMsgCtx.getAccessTokenIssuedTime() + 10000);
        tokenRespDTO.setAccessToken(UUID.randomUUID().toString());
        tokenRespDTO.setRefreshToken(UUID.randomUUID().toString());
        tokenRespDTO.setTokenType("mobile");
        return tokenRespDTO;
    }

    public boolean authorizeAccessDelegation(OAuthTokenReqMessageContext tokReqMsgCtx)
            throws IdentityOAuth2Exception {

        // if we need to just ignore the end user's extended verification

        return true;

        // if we need to verify with the end user's access delegation by calling callback chain.
        // However, you need to register a callback for this. Default call back just return true.


//        OAuthCallback authzCallback = new OAuthCallback(
//                tokReqMsgCtx.getAuthorizedUser(),
//                tokReqMsgCtx.getOauth2AccessTokenReqDTO().getClientId(),
//                OAuthCallback.OAuthCallbackType.ACCESS_DELEGATION_TOKEN);
//        authzCallback.setRequestedScope(tokReqMsgCtx.getScope());
//        authzCallback.setCarbonGrantType(org.wso2.carbon.identity.oauth.common.GrantType.valueOf(tokReqMsgCtx.
//                                                            getOauth2AccessTokenReqDTO().getGrantType()));
//        callbackManager.handleCallback(authzCallback);
//        tokReqMsgCtx.setValidityPeriod(authzCallback.getValidityPeriod());
//        return authzCallback.isAuthorized();

    }


    public boolean validateScope(OAuthTokenReqMessageContext tokReqMsgCtx)
            throws IdentityOAuth2Exception {


        // if we need to just ignore the scope verification

        return true;

        // if we need to verify with the scope n by calling callback chain.
        // However, you need to register a callback for this. Default call back just return true.
        // you can find more details on writing custom scope validator from here
        // http://xacmlinfo.org/2014/10/24/authorization-for-apis-with-xacml-and-oauth-2-0/

//        OAuthCallback scopeValidationCallback = new OAuthCallback(
//                tokReqMsgCtx.getAuthorizedUser().toString(),
//                tokReqMsgCtx.getOauth2AccessTokenReqDTO().getClientId(),
//                OAuthCallback.OAuthCallbackType.SCOPE_VALIDATION_TOKEN);
//        scopeValidationCallback.setRequestedScope(tokReqMsgCtx.getScope());
//        scopeValidationCallback.setCarbonGrantType(org.wso2.carbon.identity.oauth.common.GrantType.valueOf(tokReqMsgCtx.
//                                                            getOauth2AccessTokenReqDTO().getGrantType()));
//
//        callbackManager.handleCallback(scopeValidationCallback);
//        tokReqMsgCtx.setValidityPeriod(scopeValidationCallback.getValidityPeriod());
//        tokReqMsgCtx.setScope(scopeValidationCallback.getApprovedScope());
//        return scopeValidationCallback.isValidScope();
    }



    /**
     * TODO
     *
     * You need to implement how to validate the mobile number
     *
     * @param mobileNumber
     * @return
     */
    private boolean isValidMobileNumber(String mobileNumber){

        // just demo validation

        if(mobileNumber.startsWith("033")){
            return true;
        }

        return false;
    }

    @Override
    public boolean isOfTypeApplicationUser() throws IdentityOAuth2Exception {

        return true;
    }

}