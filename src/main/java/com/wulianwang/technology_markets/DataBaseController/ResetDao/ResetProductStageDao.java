package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResetProductStageDao {
    @Insert("CALL resetproduct_stage(#{ident},#{re_stage})")
    void  resetProductStage(
            @Param("ident") String ident,
            @Param("re_stage") String re_stage);
}

