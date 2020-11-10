package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChengguozhuanhuaDao {
    @Insert("CALL resetBiaozhi('chengguozhuanhua',#{ident})")
    void  chengguozhuanhua(
            @Param("ident") String ident);
}
