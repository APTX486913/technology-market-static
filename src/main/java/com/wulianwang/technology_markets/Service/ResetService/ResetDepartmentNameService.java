package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetDepartmentNameDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetDepartmentName_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class ResetDepartmentNameService implements ResetDepartmentName_Interface {
    @Autowired
    private ResetDepartmentNameDao resetDepartmentNameDao;
    @Override
    public void resetDepartmentName(String ident , String re_name){
        resetDepartmentNameDao.resetDepartmentName(ident ,re_name);
    }

}
