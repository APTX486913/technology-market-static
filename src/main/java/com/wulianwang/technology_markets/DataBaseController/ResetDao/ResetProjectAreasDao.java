package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ResetProjectAreasDao {
    @Insert("CALL resetproject_areas(#{ident},#{re_field})")
    void  resetProjectAreas(
            @Param("ident") String ident,
            @Param("re_field") String re_field);
}
