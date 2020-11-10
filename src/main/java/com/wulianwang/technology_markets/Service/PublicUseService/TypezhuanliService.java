package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Typezhuanli;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.TypezhuanliDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Typezhuanli_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypezhuanliService implements Typezhuanli_Interface {
    @Autowired
    private TypezhuanliDao typezhuanliDao;
    @Override
    public List<Typezhuanli> gettyppezhuanli (){ return typezhuanliDao.getTypezhuanli(); }
}
