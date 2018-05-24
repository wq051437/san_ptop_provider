package com.jk.dao;

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
    @Select("select   count(*)   from   t_personalloan   ")
    Long getrepaymentsSum();
    @Select(" select    *   from   t_personalloan   limit #{offset},#{limit} ")
    List<Personalloan> getrepaymentslist(@Param("offset") Integer offset, @Param("limit") Integer limit);
    

}
