package com.ucss.elementary.tnwn.model.database;

import java.io.Serializable;

public class SysUserRoleKey implements Serializable {
    private Long userId;

    private Long roleId;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}