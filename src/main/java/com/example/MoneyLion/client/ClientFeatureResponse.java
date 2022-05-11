package com.example.MoneyLion.client;

import javax.persistence.Entity;

public class ClientFeatureResponse {
    private Boolean canAccess;

    public ClientFeatureResponse() {
    }

    public ClientFeatureResponse(Boolean canAccess) {
        this.canAccess = canAccess;
    }

    public Boolean getCanAccess() {
        return canAccess;
    }

    public void setCanAccess(Boolean canAccess) {
        this.canAccess = canAccess;
    }

    @Override
    public String toString() {
        return "ClientFeatureResponse{" +
                "canAccess=" + canAccess +
                '}';
    }
}
