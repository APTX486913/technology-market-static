package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChengguoxinxiPassDao {
    @Insert("CALL resetBiaozhi('chengguoxinxi',#{ident})")
    void  chengguoxinxiPass(
            @Param("ident") String ident);
}
