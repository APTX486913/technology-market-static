package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.ZhuanjiaxinxiPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.ZhuanjiaxinxiPass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZhuanjiaxinxiPassService implements ZhuanjiaxinxiPass_Interface {
    @Autowired
    private ZhuanjiaxinxiPassDao zhuanjiaxinxiPassDao;
    @Override
    public void zhuanjiaxinxiPass(String ident ){
        zhuanjiaxinxiPassDao.zhuanjiaxinxiPass(ident);
    }

}
