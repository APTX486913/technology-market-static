package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShiyanshebeiDao {
    @Insert("CALL resetBiaozhi('shiyanshebei',#{ident})")
    void  shiyanshebei(
            @Param("ident") String ident);
}
