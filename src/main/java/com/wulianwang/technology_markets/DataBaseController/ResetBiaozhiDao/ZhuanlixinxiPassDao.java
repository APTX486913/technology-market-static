package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ZhuanlixinxiPassDao {
    @Insert("CALL resetBiaozhi('zhuanlixinxi',#{ident})")
    void  zhuanlixinxiPass(
            @Param("ident") String ident);
}
