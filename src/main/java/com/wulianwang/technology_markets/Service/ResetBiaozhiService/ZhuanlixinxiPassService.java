package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.ZhuanlixinxiPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.ZhuanlixinxiPass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZhuanlixinxiPassService implements ZhuanlixinxiPass_Interface {
    @Autowired
    private ZhuanlixinxiPassDao zhuanlixinxiPassDao;
    @Override
    public void zhuanlixinxiPass(String ident ){
        zhuanlixinxiPassDao.zhuanlixinxiPass(ident);
    }

}
