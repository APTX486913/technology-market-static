package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ResetAdminPermissionDao {
    @Select("CALL resetAdminPermission(#{ident},#{reperson_type_id})")
    void resetAdminPermission(@Param("ident") int identity, @Param("reperson_type_id") int reperson_type_id);

}
