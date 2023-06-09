package com.advanced.training.sample.oauth.grant.type;

import org.apache.oltu.oauth2.common.validators.AbstractValidator;

import javax.servlet.http.HttpServletRequest;

public class CustomOauthGrantValidator  extends AbstractValidator<HttpServletRequest> {


    public CustomOauthGrantValidator() {

        // mobile number must be in the request parameter
        requiredParams.add(CustomOauthGrant.MOBILE_GRANT_PARAM);
    }
}
