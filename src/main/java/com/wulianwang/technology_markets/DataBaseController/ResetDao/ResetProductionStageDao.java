package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResetProductionStageDao {
    @Insert("CALL resetproduction_stage(#{ident},#{re_stage})")
    void  resetProductionStage(
            @Param("ident") String ident,
            @Param("re_stage") String re_stage);
}
