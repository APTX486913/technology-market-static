package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Innovatexiangxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.InnovatexiangxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Innovatexiangxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InnovatexiangxiService implements Innovatexiangxi_Interface {
    @Autowired
    private InnovatexiangxiDao innovatexiangxiDao;
    @Override
    public List<Innovatexiangxi> innovatexiangxi(String identity){
        return innovatexiangxiDao.getInnovatexiangxi(identity);
    }
}
