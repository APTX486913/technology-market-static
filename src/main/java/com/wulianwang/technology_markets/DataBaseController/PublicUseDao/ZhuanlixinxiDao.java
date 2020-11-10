package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Zhuanlixinxi;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ZhuanlixinxiDao {
    @Select("Call getPatent_information(#{identity},#{start_subscript},#{pagesize})")
    @Results({
            @Result(property = "serial_number", column = "serial_number", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "type", column = "type", javaType = String.class),
            @Result(property = "number", column = "number", javaType = String.class),
            @Result(property = "apply_number", column = "apply_number", javaType = String.class),
            @Result(property = "apply_date", column = "apply_date", javaType = String.class),
            @Result(property = "patent_person", column = "patent_person", javaType = String.class),
            @Result(property = "credential_number", column = "credential_number", javaType = String.class),
            @Result(property = "contact_person", column = "contact_person", javaType = String.class),
            @Result(property = "contact_number", column = "contact_number", javaType = String.class),
            @Result(property = "E_mail", column = "E_mail", javaType = String.class),
            @Result(property = "communication_address", column = "communication_address", javaType = String.class),
            @Result(property = "postcode", column = "postcode", javaType = String.class),
            @Result(property = "jing_shou_ren", column = "jing_shou_ren", javaType = String.class),
            @Result(property = "register_date", column = "register_date", javaType = String.class),
            @Result(property = "sign", column = "sign", javaType = int.class),
            @Result(property = "xiao_result", column = "xiao_result", javaType = String.class),
            @Result(property = "ting_result", column = "ting_result", javaType = String.class),
            @Result(property = "remark", column = "remark", javaType = String.class),
            @Result(property = "organization_id", column = "organization_id", javaType = String.class),
            @Result(property = "xiao_auditor", column = "xiao_auditor", javaType = String.class),
            @Result(property = "ting_auditor", column = "ting_auditor", javaType = String.class),
            @Result(property = "tianbao_yuan", column = "tianbao_yuan", javaType = String.class),
            @Result(property = "tianbao_xiao", column = "tianbao_xiao", javaType = String.class)
    })
    List<Zhuanlixinxi> getZhuanlixinxi(@Param("identity") int identity, @Param("start_subscript") int start_subscript, @Param("pagesize") int pagesize);
}
