USE CASE : <br />
Sample scenario When a user is authenticated with an LDAP, assume that it is a requirement to add the 
authenticated time as a user attribute. To fulfill this requirement, you need to write some custom code to be 
executed after successful user authentication. The following is the custom listener implementation for this. 
The doPostAuthenticate() method would be called after actual user authentication is done. <br />

The following guide shows you how to write a custom user operation event listener. <br />
https://is.docs.wso2.com/en/6.0.0/references/extend/user-mgt/user-store-listeners/