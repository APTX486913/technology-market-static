package com.wulianwang.technology_markets.Interface.AddInterface;

import org.apache.ibatis.annotations.Param;

public interface Addqiyexuqiu_Interface {
    void  addqiyexuqiu(
            String id ,
            String name,
             String context,
             String e_id ,
             String date,
             int status,
             String type
    );
}
