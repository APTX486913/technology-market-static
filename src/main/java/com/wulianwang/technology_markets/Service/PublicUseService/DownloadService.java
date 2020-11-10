package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Download;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.DownloadDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Download_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownloadService implements Download_Interface {
    @Autowired
    private DownloadDao downloadDao;
    @Override
    public List<Download> download(int start_subscript, int pagesize ){
       return downloadDao.getDownload(start_subscript,pagesize);
    }
}
