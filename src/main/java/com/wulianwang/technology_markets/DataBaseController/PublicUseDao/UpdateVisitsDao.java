package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateVisitsDao {
    @Insert("Call updateVisits()")
    void updateVisits();
    @Select("Call getVisits()")
    int getVisits();
}
