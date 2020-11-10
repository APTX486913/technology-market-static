package com.wulianwang.technology_markets.DataBaseController.FiltrateDao;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lhk
 * @description
 * @create 2020-10-15 19:17
 */
@Mapper
@Repository
public interface FiltrateinfoDao {
    @Select("call filtrateinfo(#{dataFrom},#{type},#{school},#{begin_time},#{end_time},#{start_subscript},#{pagesize})")
    List<Map<String,Object>> filtrateinfo(@Param("dataFrom") String dataFrom, @Param("type") String type, @Param("school") String school, @Param("begin_time") String begin_time, @Param("end_time") String end_time,
                                          @Param("start_subscript")int start_subscript,
                                          @Param("pagesize")int pagesize);
}
