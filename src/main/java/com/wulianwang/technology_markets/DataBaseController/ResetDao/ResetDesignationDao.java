package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResetDesignationDao {
    @Insert("CALL resetdesignation(#{ident},#{re_designation})")
    void  resetDesignation(
            @Param("ident") String ident,
            @Param("re_designation") String re_designation);
}
