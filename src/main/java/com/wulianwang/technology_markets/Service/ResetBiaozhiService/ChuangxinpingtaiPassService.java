package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.ChuangxinpingtaiPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.ChuangxinpingtaiPass_Interface;
import org.mapstruct.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChuangxinpingtaiPassService implements ChuangxinpingtaiPass_Interface {
    @Autowired
    private ChuangxinpingtaiPassDao chuangxinpingtaiPassDao;
    @Override
    public void chuangxinpingtaiPass(String ident ){
        chuangxinpingtaiPassDao.chuangxinpingtaiPass(ident);
    }
}
