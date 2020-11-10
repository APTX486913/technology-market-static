package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddshengchanjieduanDao {
    @Insert("CALL addProduction_stage(#{id},#{stage},#{value},#{biaozhi})")
    void  addshengchanjieduan(
            @Param("id") String id ,
            @Param("stage") String stage,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
