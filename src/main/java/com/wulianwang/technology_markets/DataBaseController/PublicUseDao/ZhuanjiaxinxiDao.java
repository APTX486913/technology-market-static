package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Zhuanjiaxinxi;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ZhuanjiaxinxiDao {
    @Select("Call getProfessor_information(#{identity},#{start_subscript},#{pagesize})")
    @Results({
            @Result(property = "professor_number", column = "professor_number", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "gender", column = "gender", javaType = String.class),
            @Result(property = "born_date", column = "born_date", javaType = String.class),
            @Result(property = "industry_1", column = "industry_1", javaType = String.class),
            @Result(property = "industry_2", column = "industry_2", javaType = String.class),
            @Result(property = " education_background", column = " education_background", javaType = String.class),
            @Result(property = "zhi_cheng", column = "zhi_cheng", javaType = String.class),
            @Result(property = "duty", column = "duty", javaType = String.class),
            @Result(property = "level", column = "level", javaType = int.class),
            @Result(property = "title", column = "title", javaType = String.class),
            @Result(property = "organization", column = "organization", javaType = String.class),
            @Result(property = "ID_number", column = "ID_number", javaType = String.class),
            @Result(property = "commodation_address", column = "commodation_address", javaType = String.class),
            @Result(property = "E_maile", column = "E_maile", javaType = String.class),
            @Result(property = "phone_number", column = "phone_number", javaType = String.class),
            @Result(property = "intro", column = "intro", javaType = String.class),
            @Result(property = "photograph", column = "photograph", javaType = String.class),
            @Result(property = "jing_shou_ren", column = "jing_shou_ren", javaType = String.class),
            @Result(property = "register_date", column = "register_date", javaType = String.class),
            @Result(property = "sign", column = "sign", javaType = int.class),
            @Result(property = "check_result_xiao", column = "check_result_xiao", javaType = String.class),
            @Result(property = "check_result_ting", column = "check_result_ting", javaType = String.class),
            @Result(property = "remarks", column = "remarks", javaType = String.class),
            @Result(property = "organization_number", column = "organization_number", javaType = String.class),
            @Result(property = "auditor_xiao", column = "auditor_xiao", javaType = String.class),
            @Result(property = "auditor_ting", column = "auditor_ting", javaType = String.class),
            @Result(property = "tianbao_yuan", column = "tianbao_yuan", javaType = String.class),
            @Result(property = "tianbao_xiao", column = "tianbao_xiao", javaType = String.class)
    })
    List<Zhuanjiaxinxi> getZhuanjiaxinxi(@Param("identity") int identity, @Param("start_subscript") int start_subscript, @Param("pagesize") int pagesize);
}

