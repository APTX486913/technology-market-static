package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetAdminPermissionDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetAdminPermission_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetAdminPermissionService implements ResetAdminPermission_Interface {
    @Autowired
    private ResetAdminPermissionDao resetAdminPermissionDao;
    @Override
    public void resetAdminPermission(int ident, int reperson_type_id) {
        resetAdminPermissionDao.resetAdminPermission(ident, reperson_type_id);
    }
}
