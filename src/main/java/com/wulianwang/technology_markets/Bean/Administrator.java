package com.wulianwang.technology_markets.Bean;

public class Administrator {
    private int identity;  //管理员id
    private String adminName;//用户名
    private int permission; //确定是何种管理员
    private int organizationid;
    private int biaozhi;


    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(int organizationid) {
        this.organizationid = organizationid;
    }

    public int getBiaozhi() {
        return biaozhi;
    }

    public void setBiaozhi(int biaozhi) {
        this.biaozhi = biaozhi;
    }
}
