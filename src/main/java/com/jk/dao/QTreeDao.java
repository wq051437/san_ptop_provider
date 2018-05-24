package com.jk.dao;

import com.jk.model.QTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by new鹏 on 2018/5/22.
 */
@Mapper
public interface QTreeDao {
    @Select(" select   *    from   t_trees  where   t_trees.pid=#{i} ")
    List<QTree> menuList(int i);
}
