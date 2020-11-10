package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResetDeclareTypeDao {
    @Insert("CALL resetdeclare_type(#{ident},#{re_type})")
    void  resetDeclareType(
            @Param("ident") String ident,
            @Param("re_type") String re_type);
}
