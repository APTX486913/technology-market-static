package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddshenbaoleibieDao {
    @Insert("CALL addDeclare_type(#{id},#{type},#{value},#{biaozhi})")
    void  addshenbaoleibie(
            @Param("id") String id ,
            @Param("type") String type,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi

    );
}
