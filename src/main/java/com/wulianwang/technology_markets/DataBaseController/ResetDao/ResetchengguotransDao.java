package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ResetchengguotransDao {
    @Insert("CALL resetbiaozhi_achiev_trans(#{ident})")
    void  resetchengguotrans(
            @Param("ident") String ident);
}
