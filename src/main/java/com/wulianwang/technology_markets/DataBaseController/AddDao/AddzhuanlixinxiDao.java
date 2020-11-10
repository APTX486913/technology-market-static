package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddzhuanlixinxiDao {
    @Insert("Call addPatent(#{serial_number},#{name},#{type }" +
            "#{number},#{apply_number},#{ apply_date}" +
            "#{patent_person},#{credential_number},#{contact_person }" +
            "#{contact_number},#{E_mail},#{ communication_address}" +
            "#{postcode},#{jing_shou_ren},#{ register_date}" +
            "#{sign},#{xiao_result},#{ ting_result}" +
            "#{remark},#{organization_id},#{ xiao_auditor}" +
            "#{ting_auditor},#{tianbao_yuan}}" + "#{ tianbao_xiao})")
    void addczhuanlixinxi(@Param("serial_number") String serial_number, @Param("name")String name, @Param("type") String type,
                             @Param("number") String number, @Param("apply_number")String apply_number, @Param("apply_date") String apply_date,
                             @Param("patent_person") String patent_person, @Param("credential_number") String credential_number, @Param("contact_person")  String contact_person,
                             @Param("contact_number") String contact_number, @Param("E_mail") String E_mail, @Param("communication_address")  String communication_address,
                          @Param("postcode") String postcode, @Param("jing_shou_ren") String jing_shou_ren, @Param("register_date")  String register_date,
                          @Param("sign") int sign, @Param("xiao_result") String xiao_result, @Param("ting_result")  String ting_result,
                             @Param("remark") String remark, @Param("organization_id") String organization_id, @Param("xiao_auditor") String xiao_auditor ,
                             @Param("ting_auditor") String ting_auditor,@Param("tianbao_yuan") String tianbao_yuan,@Param("tianbao_xiao") String tianbao_xiao);

}
