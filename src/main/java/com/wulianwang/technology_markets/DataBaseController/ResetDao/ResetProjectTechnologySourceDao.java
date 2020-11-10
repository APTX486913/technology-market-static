package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ResetProjectTechnologySourceDao {
    @Insert("CALL resetproject_technology_source(#{ident},#{reproject_technology_sourc})")
    void  resetProjectTechnologySource(
            @Param("ident") String ident,
            @Param("reproject_technology_sourc") String reproject_technology_sourc);
}
