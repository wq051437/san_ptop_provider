package com.jk.LoggerDao.impl;

import java.util.List;

import com.jk.LoggerDao.LoggerDao;
import com.jk.model.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository
public class LoggerDaoImpl    implements LoggerDao {
	
	@Autowired
    private	    MongoTemplate   mongoTemplate;
	
	public Long getcount() {
		Query query = new Query();
	    int	count = (int) mongoTemplate.count(query, Logs.class,"logs");
	    return (long) count;
	}

	public List getList(Integer offset, Integer limit) {
		Query query = new Query();
		//开始条数
		query.skip(offset);
		//查几条
		query.limit(limit);
		List<Logs> list = mongoTemplate.find(query, Logs.class,"logs");
		return list;
	}
}
