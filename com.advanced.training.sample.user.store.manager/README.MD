USE CASE : <br /> 
Consider a sample scenario where you want to use a custom hashing method using a 3rd party library 
such as Jasypt and to do this, you need to override the doAuthentication and preparePassword methods.

Consider a sample scenario that you have to plug a database which contains different schemas than Identity Server 
schemas where you have user data. In this case existing user store managers will not cater as the underlying schema 
is different. To solve this issue we can create a custom user store manager to be compatible with a custom schema.

CONFIGURATION : <br />

[user_store_mgt] <br />
custom_user_stores=["new user store", "existing user stores"] <br />

The following guide shows you how to write a custom user store manager. <br />
https://is.docs.wso2.com/en/6.0.0/references/extend/write-a-custom-user-store-manager/#write-a-custom-user-store-manager-for-a-sample-scenario