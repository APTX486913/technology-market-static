package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Downloadfile;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.DownloadfileDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Downloadfile_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownloadfileService implements Downloadfile_Interface {
    @Autowired
    private DownloadfileDao downloadfileDao;
    @Override
    public List<Downloadfile> downloadfile(int file_id){
        return downloadfileDao.getDownloadfile(file_id);
    }

}
