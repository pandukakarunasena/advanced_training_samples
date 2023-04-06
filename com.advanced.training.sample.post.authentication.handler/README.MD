
USE CASE : This sample will act as a post authenticator which will request for your consent for retrieving user 
information from IS to Service provider, upon successfully passing authentication steps. 
The behaviour of this post authentication handler is a consent page will be popped up upon successfully passing authentication steps.
If you click on approve, then you will be redirected to your application with successful login
If you deny the consent, authentication will be failed and you will be shown an error message on the screen.


CONFIGURATION : 

[[event_listener]]
id = "custom_post_auth_listener"
type = "org.wso2.carbon.identity.core.handler.AbstractIdentityHandler"
name = "com.advanced.training.sample.post.authentication.handler.CustomPostAuthenticationHandler"
order = 899

The following guide shows you how to write a custom post authentication handler.
https://is.docs.wso2.com/en/6.0.0/references/extend/user-mgt/write-a-post-authentication-handler/#write-a-post-authentication-handler_1