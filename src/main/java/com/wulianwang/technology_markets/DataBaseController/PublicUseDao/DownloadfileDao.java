package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Download;
import com.wulianwang.technology_markets.Bean.Downloadfile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DownloadfileDao {
    @Select("Call getDownload_file(#{file_id})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "id", column = "ident", javaType = int.class),
            @Result(property = "download_title", column = "download_title", javaType = String.class),
            @Result(property = "download_content", column = "download_content", javaType = String.class),
            @Result(property = "download_link", column = "link", javaType = String.class),
            @Result(property = "release_time", column = "release_time", javaType = String.class),

    })
    List<Downloadfile> getDownloadfile(@Param("file_id") int file_id);


}
