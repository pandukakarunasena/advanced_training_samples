package com.advanced.training.sample.user.store.manager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.wso2.carbon.user.api.RealmConfiguration;
import org.wso2.carbon.user.core.UserCoreConstants;
import org.wso2.carbon.user.core.UserRealm;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.claim.ClaimManager;
import org.wso2.carbon.user.core.common.AuthenticationResult;
import org.wso2.carbon.user.core.common.FailureReason;
import org.wso2.carbon.user.core.common.User;
import org.wso2.carbon.user.core.jdbc.JDBCRealmConstants;
import org.wso2.carbon.user.core.jdbc.UniqueIDJDBCUserStoreManager;
import org.wso2.carbon.user.core.profile.ProfileConfigurationManager;
import org.wso2.carbon.utils.Secret;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * This class implements the Custom User Store Manager.
 */
public class CustomUserStoreManager extends UniqueIDJDBCUserStoreManager {

    private static final Log log = LogFactory.getLog(CustomUserStoreManager.class);

    private static final StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();


    public CustomUserStoreManager() {

    }

    public CustomUserStoreManager(RealmConfiguration realmConfig, Map<String, Object> properties, ClaimManager
            claimManager, ProfileConfigurationManager profileManager, UserRealm realm, Integer tenantId)
            throws UserStoreException {

        //add code here
    }


    @Override
    public AuthenticationResult doAuthenticateWithUserName(String userName, Object credential)
            throws UserStoreException {

        //add code here
        return null;
    }

    @Override
    protected String preparePassword(Object password, String saltValue) throws UserStoreException {

        //add code here
        return null;
    }

}
