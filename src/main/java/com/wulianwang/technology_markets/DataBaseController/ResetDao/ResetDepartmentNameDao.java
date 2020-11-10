package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ResetDepartmentNameDao {
    @Insert("CALL resetdepartment_name(#{ident},#{re_name})")
    void  resetDepartmentName(
            @Param("ident") String ident,
            @Param("re_name") String re_name);

}
