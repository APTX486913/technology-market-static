package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddsuoshulingyuDao {
    @Insert("CALL addProject_areas(#{id},#{field},#{value},#{biaozhi})")
    void  addsuoshulingyu(
            @Param("id") String id ,
            @Param("field") String field,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
