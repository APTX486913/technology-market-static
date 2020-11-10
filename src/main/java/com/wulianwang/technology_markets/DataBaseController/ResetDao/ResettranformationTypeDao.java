package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResettranformationTypeDao {
    @Insert("CALL resettranformation_type(#{ident},#{re_tyrp})")
    void  resettranformationType(
            @Param("ident") String ident,
            @Param("re_tyrp") String re_tyrp);
}
