USE CASE : <br /> 
Consider a sample scenario where you want to use a custom hashing method using a 3rd party library 
such as Jasypt and to do this, you need to override the doAuthentication and preparePassword methods.

CONFIGURATION : <br />

[user_store_mgt] <br />
custom_user_stores=["new user store", "existing user stores"] <br />

The following guide shows you how to write a custom user store manager. <br />
https://is.docs.wso2.com/en/6.0.0/references/extend/write-a-custom-user-store-manager/#write-a-custom-user-store-manager-for-a-sample-scenario