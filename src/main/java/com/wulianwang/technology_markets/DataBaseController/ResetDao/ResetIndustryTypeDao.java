package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ResetIndustryTypeDao {
    @Insert("CALL resetindustry_type(#{ident},#{re_type})")
    void  resetIndustryType(
            @Param("ident") String ident,
            @Param("re_type") String re_type);
}
