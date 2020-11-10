package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddjijinlaiyuanDao {
    @Insert("CALL addFund_resources(#{id},#{resources},#{value},#{biaozhi})")
    void  addjijinlaiyuan(
            @Param("id") String id ,
            @Param("resources") String resources,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
