package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResetFundResourcesDao {
    @Insert("CALL resetfund_resources(#{ident},#{re_resources})")
    void  resetFundResources(
            @Param("ident") String ident,
            @Param("re_resources") String re_resources);
}
