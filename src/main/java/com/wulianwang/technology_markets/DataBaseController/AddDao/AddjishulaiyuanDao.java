package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddjishulaiyuanDao {
    @Insert("CALL addProjet_technology_source(#{id},#{project_technology_sourc},#{value},#{biaozhi})")
    void  addjishulaiyuan(
            @Param("id") String id ,
            @Param("project_technology_sourc") String project_technology_sourc,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi);
}
