package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddxiangmulaiyuanDao {
    @Insert("CALL addPlan_source(#{id},#{plan_source},#{value},#{biaozhi})")
    void  addxiangmulaiyuan(
            @Param("id") String id ,
            @Param("plan_source") String plan_source,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
