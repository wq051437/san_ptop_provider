package com.jk.LoggerDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoggerDao {

	Long getcount();
	
	List getList(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
