package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ResettechchengguopassDao {
    @Insert("CALL resetbiaozhi_achiev_indust(#{ident})")
    void  resettechchengguopass(
            @Param("ident") String ident);
}
