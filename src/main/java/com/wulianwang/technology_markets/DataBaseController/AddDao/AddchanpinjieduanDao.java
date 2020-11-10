package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddchanpinjieduanDao {
    @Insert("CALL addProduct_stage(#{id},#{stage},#{value},#{biaozhi})")
    void  addchanpinjieduan(
            @Param("id") String id,
            @Param("stage") String stage,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
