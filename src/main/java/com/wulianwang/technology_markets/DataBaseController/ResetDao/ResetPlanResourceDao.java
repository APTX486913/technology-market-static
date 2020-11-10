package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResetPlanResourceDao {
    @Insert("CALL resetplan_resource(#{ident},#{re_name})")
    void  resetPlanResource(
            @Param("ident") String ident,
            @Param("re_plan_source") String re_plan_source);
}
