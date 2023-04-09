package com.advanced.training.sample.user.operation.event.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.common.AbstractUserOperationEventListener;

import java.lang.Override;
import java.lang.String;

import java.util.Map;

public class CustomUserOperationEventListener extends AbstractUserOperationEventListener {

    private static Log log = LogFactory.getLog(CustomUserOperationEventListener.class);

    @Override
    public int getExecutionOrderId() {
        return 9883;
    }


    @Override
    public boolean doPostAuthenticate(String userName, boolean authenticated, UserStoreManager userStoreManager) throws UserStoreException {

        //add code here

        return true;
    }

    @Override
    public boolean doPostAddUser(String userName, Object credential, String[] roleList,
                                 Map<String, String> claims, String profile,
                                 UserStoreManager userStoreManager)
            throws UserStoreException {

        //add code here

        return true;
    }


    @Override
    public boolean doPostSetUserClaimValues(String userName, Map<String, String> claims,
                                            String profileName, UserStoreManager userStoreManager)
            throws UserStoreException {

        //add code here

        return true;
    }
}
