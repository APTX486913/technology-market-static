package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Xiangmulaiyuan;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.XiangmulaiyuanDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmulaiyuan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiangmulaiyuanService implements Xiangmulaiyuan_Interface {
    @Autowired
    private XiangmulaiyuanDao xiangmulaiyuanDao;
    @Override
    public List<Xiangmulaiyuan> getxiangmulaiyuan() {
        return xiangmulaiyuanDao.getXiangmulaiyuan();
    }

}
