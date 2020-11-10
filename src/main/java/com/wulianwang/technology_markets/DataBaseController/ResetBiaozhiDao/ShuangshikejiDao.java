package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShuangshikejiDao {
    @Insert("CALL resetBiaozhi('shuangshikeji',#{ident})")
    void  shuangshikeji(
            @Param("ident") String ident);
}
