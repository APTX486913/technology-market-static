package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddchenghaoDao {
    @Insert("CALL addDesignation(#{id},#{designation},#{value},#{biaozhi})")
    void  addchenghao(
            @Param("id") String id ,
            @Param("designation") String designation,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
