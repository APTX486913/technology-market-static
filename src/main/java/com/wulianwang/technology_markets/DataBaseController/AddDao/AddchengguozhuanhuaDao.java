package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddchengguozhuanhuaDao {
    @Insert("Call addAchtran(#{transformation_project_item},#{transformation_service_type},#{transformation_project_name }" +
            "#{transformation_project_application},#{project_introduction},#{ jingshouren}" +
            "#{approval_mark},#{approval_result_school},#{approval_result_hall }" +
            "#{organization_id},#{verifier_scchool},#{ verifier_hall}" +
            "#{reporting_unit_court},#{reporting_unit_school},#{ contact}" +"#{ contact_phone})")
    void addchengguozhuanhua(@Param("transformation_project_item") String transformation_project_item, @Param("transformation_service_type")String transformation_service_type, @Param("transformation_project_name") String transformation_project_name,
    @Param("transformation_project_application") String transformation_project_application, @Param("project_introduction")String project_introduction, @Param("jingshouren") String jingshouren,
    @Param("approval_mark") int approval_mark, @Param("approval_result_school") String approval_result_school, @Param("approval_result_hall")  String approval_result_hall,
                             @Param("organization_id") String organization_id, @Param("verifier_scchool") String verifier_scchool, @Param("verifier_hall")  String verifier_hall,
    @Param("reporting_unit_court") String reporting_unit_court, @Param("reporting_unit_school") String reporting_unit_school, @Param("contact") String contact ,
                             @Param("contact_phone") String contact_phone);
}
