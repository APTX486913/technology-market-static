package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChuangxinpingtaiPassDao {
    @Insert("CALL resetBiaozhi('chuangxinpingtai',#{ident})")
    void  chuangxinpingtaiPass(
            @Param("ident") String ident);
}
