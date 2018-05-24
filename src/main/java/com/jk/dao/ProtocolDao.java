package com.jk.dao;

import com.jk.model.Protocol;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 周玉路 on 2018/5/16.
 */
@Mapper
public interface ProtocolDao {

    long queryProtocolManageCount(@Param("protocol") Protocol protocol, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("grname") String grname);

    List<Protocol> queryProtocolManagePage(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("protocol") Protocol protocol, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("grname") String grname);

    @Update("update t_protocol  set t_protocol.protecttype=1 where 1 = 1")
    void updateProtocol();
     @Update(" update t_protocol  set t_protocol.protecttype=1  where  protocolid=#{protocolid}  ")
    void updatelist(Integer protocolid);
}
