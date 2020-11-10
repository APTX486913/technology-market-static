package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AddqiyexuqiuDao {
    @Insert("CALL addComerq(#{id},#{name},#{content},#{e_id},#{date},#{status},#{type})")
    void  addqiyexuqiu(
            @Param("id") String id ,
            @Param("name") String name,
            @Param("context") String context,
            @Param("e_id") String e_id ,
            @Param("date") String date,
            @Param("status") int status,
            @Param("type") String type
    );

}
