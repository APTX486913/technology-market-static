package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Zhicheng;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ZhichengDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhicheng_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhichengService implements Zhicheng_Interface {
    @Autowired
private ZhichengDao zhichengDao;
    @Override
    public List<Zhicheng> zhicheng(){
        return zhichengDao.getZhicheng();
    }
}
