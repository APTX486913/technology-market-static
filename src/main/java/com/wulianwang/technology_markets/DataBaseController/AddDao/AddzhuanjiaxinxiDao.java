package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddzhuanjiaxinxiDao {
    @Insert("Call addProfessor(#{professor_number},#{name},#{gender }" +
            "#{born_date},#{industry_1},#{ industry_2}" +
            "#{education_background},#{zhi_cheng},#{ duty}" +
            "#{level},#{title},#{ organization}" +
            "#{ID_number},#{commodation_address},#{ E_maile}" +
            "#{jing_shou_ren},#{register_date},#{ sign}" +
            "#{check_result_xiao},#{check_result_ting},#{ remarks}" +
            "#{organization_number},#{auditor_xiao},#{ auditor_ting}" +
            "#{tianbao_yuan},#{tianbao_xiao})")
    void addzhuanjiaxinxi(@Param("professor_number") String professor_number, @Param("name") String name, @Param("gender") String gender,
                             @Param("born_date") String born_date, @Param("industry_1") String industry_1, @Param("industry_2") String industry_2,
                             @Param("education_background") String education_background, @Param("zhi_cheng") String zhi_cheng, @Param("duty") String duty,
                             @Param("level") int level, @Param("title") String title, @Param("organization") String organization,
                             @Param("ID_number") String ID_number, @Param("commodation_address") String commodation_address, @Param("E_maile") String E_maile,
                             @Param("jing_shou_ren") String jing_shou_ren, @Param("register_date") String register_date, @Param("sign") int sign,
                             @Param("check_result_xiao") String check_result_xiao, @Param("check_result_ting") String check_result_ting, @Param("remarks") String remarks,
                             @Param("organization_number") String organization_number, @Param("auditor_xiao") String auditor_xiao,
                             @Param("auditor_ting") String auditor_ting, @Param("tianbao_yuan") String tianbao_yuan, @Param("tianbao_xiao") String tianbao_xiao);

}
