package com.ucss.elementary.weather.model.database;

public class TDUserNewExtension extends TDUser {
    public String getRolenames() {
        return rolenames;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }

    String rolenames;
}