package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddzhuanhuafuwuDao {
    @Insert("CALL addTran_service_type(#{id},#{type},#{value},#{biaozhi})")
    void  addzhuanhuafuwu(
            @Param("id") String id ,
            @Param("type") String type,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
