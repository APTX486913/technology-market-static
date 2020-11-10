package com.wulianwang.technology_markets.Bean;

import org.apache.ibatis.annotations.Param;

public class Chanpinjieduan {
    String id;
    String stage;
    int value;
    String biaozhi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getBiaozhi() {
        return biaozhi;
    }

    public void setBiaozhi(String biaozhi) {
        this.biaozhi = biaozhi;
    }
}
