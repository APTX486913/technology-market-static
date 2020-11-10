package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ResetappnameDao {
    @Insert("CALL resetapplication_name(#{ident},#{re_name})")
    void  resetappname(
            @Param("ident") String ident,
            @Param("re_name") String re_name);
}
