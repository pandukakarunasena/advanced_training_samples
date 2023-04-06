package com.advanced.training.sample.event.handler.internal;

import org.wso2.carbon.user.core.service.RealmService;

public class CustomEventHandlerDataComponent {

    private static CustomEventHandlerDataComponent instance = new CustomEventHandlerDataComponent();
    private RealmService realmService;

    public static CustomEventHandlerDataComponent getInstance() {
        return instance;
    }

    public RealmService getRealmService() {
        return realmService;
    }

    public void setRealmService(RealmService realmService) {
        this.realmService = realmService;
    }
}
