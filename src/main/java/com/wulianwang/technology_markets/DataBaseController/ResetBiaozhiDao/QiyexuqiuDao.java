package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QiyexuqiuDao {
    @Insert("CALL resetBiaozhi('qiyexuqiu',#{ident})")
    void  qiyexuqiu(
            @Param("ident") String ident);
}
