package com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RuanjianzhuzuoquanPassDao {
    @Insert("CALL resetBiaozhi('ruanjianzhuzuoquan',#{ident})")
    void  ruanjianzhuzuoquanPass(
            @Param("ident") String ident);
}
