package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Xiangmujibie;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.XiangmujibieDao;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.XiangmulaiyuanDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmujibie_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmulaiyuan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiangmujibieService implements Xiangmujibie_Interface {
    @Autowired
    private XiangmujibieDao xiangmujibieDao;
    @Override
    public List<Xiangmujibie> getxiangmujibie(){
        return xiangmujibieDao.getXiangmujibie();
    }
}
