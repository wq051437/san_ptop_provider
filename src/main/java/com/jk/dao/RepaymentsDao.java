package com.jk.dao;

import com.jk.model.CollectionBean;
import com.jk.model.Personalloan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by new鹏 on 2018/5/17.
 */
@Mapper
public interface RepaymentsDao {

    List<Personalloan> getrepaymentslist(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("personalloan2") Personalloan personalloan2,@Param("starttime") String starttime, @Param("endtime") String endtime );

    List<Personalloan> getrepaymentslist2(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("personalloan2") Personalloan personalloan2);

    List<Personalloan> getrepaymentslist3(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("personalloan2") Personalloan personalloan2);

    /**
     * 查询个人信息
     * @param userid
     * @return
     */
    List querylistgeren(Integer userid);


}
