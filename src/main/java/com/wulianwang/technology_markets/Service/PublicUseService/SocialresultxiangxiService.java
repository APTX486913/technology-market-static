package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Socialresult;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.SocialresultxiangxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Socialresultxiangxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialresultxiangxiService implements Socialresultxiangxi_Interface {
    @Autowired
    private SocialresultxiangxiDao socialresultxiangxiDao;
    @Override
    public List<Socialresult> socialresultxiangxi(int identity){
        return socialresultxiangxiDao.getsocialresultxiangxi(identity);
    }
}
