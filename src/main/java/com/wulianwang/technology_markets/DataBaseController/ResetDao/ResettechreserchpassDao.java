package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResettechreserchpassDao {
    @Insert("CALL resetbiaozhi_achiev_research(#{ident})")
    void  resettechreserchpass(
            @Param("ident") String ident);
}
