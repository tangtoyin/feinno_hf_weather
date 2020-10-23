package com.ucss.elementary.weather.model.database;


public class SysApiKeyExtension extends SysApikey {
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
