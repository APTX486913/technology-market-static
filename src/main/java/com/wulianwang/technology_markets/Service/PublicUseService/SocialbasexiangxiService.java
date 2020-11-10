package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Socialbasexiangxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.SocialbasexiangxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Socialbasexiangxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialbasexiangxiService implements Socialbasexiangxi_Interface {
    @Autowired
    private SocialbasexiangxiDao socialbasexiangxiDao;
    @Override
    public List<Socialbasexiangxi> socialbasexiangxi(int identity){
        return socialbasexiangxiDao.getSocialbasexiangxi(identity);
    }
}
