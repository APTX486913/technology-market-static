package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Hangyetype;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.HangyetypeDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Hangyetype_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangyetypeService implements Hangyetype_Interface {
    @Autowired
    private HangyetypeDao hangyetypeDao;
    @Override
    public List<Hangyetype> hangyetype(){
        return hangyetypeDao.getHangyetype();
    }
}
