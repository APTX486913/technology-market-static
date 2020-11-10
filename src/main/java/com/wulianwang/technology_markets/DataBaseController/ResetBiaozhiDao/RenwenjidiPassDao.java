package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RenwenjidiPassDao {
    @Insert("CALL resetBiaozhi('renwenjidi',#{ident})")
    void  renwenjidiPass(
            @Param("ident") String ident);
}
