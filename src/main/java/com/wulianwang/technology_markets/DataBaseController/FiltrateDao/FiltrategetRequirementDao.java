package com.wulianwang.technology_markets.DataBaseController.FiltrateDao;

import com.wulianwang.technology_markets.Bean.Comxxrequire;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface FiltrategetRequirementDao {
    @Select("Call filtrategetRequirement(#{requirement_type},#{start_subscript},#{pagesize})")
    List<Comxxrequire> filtrategetRequirement(@Param("requirement_type")String requirement_type,
                                              @Param("start_subscript")int start_subscript,
                                              @Param("pagesize")int pagesize);
}
