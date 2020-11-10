package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Xiaohangyetype;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.XiaohangyetypeDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiaohangyetype_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiaohangyetypeService implements Xiaohangyetype_Interface {
    @Autowired
    private XiaohangyetypeDao xiaohangyetypeDao;

    @Override
    public List<Xiaohangyetype> xiaohangyetype(String industry_big) {
        return xiaohangyetypeDao.getXiaohangyetype(industry_big);
    }
}
