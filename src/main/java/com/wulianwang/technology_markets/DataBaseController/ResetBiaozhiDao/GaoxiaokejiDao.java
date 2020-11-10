package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GaoxiaokejiDao {
    @Insert("CALL resetBiaozhi('gaoxiaokeji',#{ident})")
    void  gaoxiaokeji(
            @Param("ident") String ident);
}
