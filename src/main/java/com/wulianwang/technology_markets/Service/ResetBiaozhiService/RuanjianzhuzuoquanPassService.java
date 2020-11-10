package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.RuanjianzhuzuoquanPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.RuanjianzhuzuoquanPass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuanjianzhuzuoquanPassService implements RuanjianzhuzuoquanPass_Interface {
    @Autowired
    private RuanjianzhuzuoquanPassDao ruanjianzhuzuoquanPassDao;
    @Override
    public void ruanjianzhuzuoquanPass(String ident ){
        ruanjianzhuzuoquanPassDao.ruanjianzhuzuoquanPass(ident);
    }

}
