package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddhangyeleixingDao {
    @Insert("CALL addIndustry_type(#{id},#{type},#{value},#{biaozhi})")
    void  addhangyeleixing(
            @Param("id") String id ,
            @Param("type") String type,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
