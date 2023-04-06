USE CASE : Consider a sample scenario where you want to use a custom hashing method using a 3rd party library 
such as Jasypt and to do this, you need to override the doAuthentication and preparePassword methods.

CONFIGURATION :

[user_store_mgt]
custom_user_stores=["<new userstore>", "<exisiting user stores>"]

The following guide shows you how to write a custom user store manager.
https://is.docs.wso2.com/en/6.0.0/references/extend/write-a-custom-user-store-manager/#write-a-custom-user-store-manager-for-a-sample-scenario