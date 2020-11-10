package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface DeleteInfDao {
        @Select("CALL deleteInf(#{moduleName},#{identity})")
        void deleteInf(@Param("moduleName") String moduleName, @Param("identity") int identity);
}