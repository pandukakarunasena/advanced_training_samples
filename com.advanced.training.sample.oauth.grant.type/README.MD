USE CASE : <br />
The sample demonstrated here defines a new sample grant type called the "mobile" grant type. 
It is similar to the password grant type and the only difference is that a mobile number will be 
passed through instead of a password. The request to the /token API must contain the following two request parameters.<br />

grant_type=mobile
mobileNumber=044322433

CONFIGURATION : <br />
[[oauth.custom_grant_type]] <br />
name="mobile" <br />
grant_handler="org.wso2.sample.identity.oauth2.grant.mobile.MobileGrant" <br />
grant_validator="org.wso2.sample.identity.oauth2.grant.mobile.MobileGrantValidator" <br />

[oauth.custom_grant_type.properties] <br />
IdTokenAllowed=true <br />

The following guide shows you how to write a custom grant type. <br />
https://is.docs.wso2.com/en/6.0.0/references/extend/oauth2/write-a-custom-oauth-2.0-grant-type/#implement-a-new-grant-type    