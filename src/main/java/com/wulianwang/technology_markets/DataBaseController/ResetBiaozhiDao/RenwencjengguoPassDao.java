package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RenwencjengguoPassDao {
    @Insert("CALL resetBiaozhi('renwencjengguo',#{ident})")
    void  renwencjengguoPass(
            @Param("ident") String ident);
}
