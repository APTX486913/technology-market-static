package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AddjihuajijinDao {
    @Insert("CALL addDepartment_fund(#{id},#{name},#{value},#{biaozhi})")
    void  addjihuajijin(
            @Param("id") String id ,
            @Param("name") String name,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
