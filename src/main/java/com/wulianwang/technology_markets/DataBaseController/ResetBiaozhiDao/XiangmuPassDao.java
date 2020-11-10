package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XiangmuPassDao {
    @Insert("CALL resetBiaozhi('xiangmu',#{ident})")
    void  xiangmuPass(
            @Param("ident") String ident);
}
