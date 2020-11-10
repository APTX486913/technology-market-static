package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ZhuanjiaxinxiPassDao {
    @Insert("CALL resetBiaozhi('zhuanjiaxinxi',#{ident})")
    void  zhuanjiaxinxiPass(
            @Param("ident") String ident);
}
