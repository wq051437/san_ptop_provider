package com.jk.service.impl;

import com.jk.dao.QTreeDao;
import com.jk.model.QTree;
import com.jk.model.QUserBean;
import com.jk.service.QTreeService;
import com.jk.service.QUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by new鹏 on 2018/5/22.
 */
@Service("qTreeService")
public class QTreeServiceImpl   implements QTreeService {

    @Resource
    private QTreeDao qTreeDao;

    @Override
    public List<QTree> threelist() {
        // 查询一级菜单
        List<QTree> firstMenu = qTreeDao.menuList(0);
        // 查询一级菜单的子菜单
        recursionMenu(firstMenu);
        return firstMenu;
    }
    /**
     * 递归加载子菜单
     */
    public void recursionMenu(List<QTree> firstMenu) {
        for (QTree qtree : firstMenu) {
            // 查询菜单是否有子菜单
            List<QTree> menuList2 = qTreeDao.menuList(qtree.getId());
            if (menuList2.size() > 0) {
                qtree.setNodes(menuList2);
                recursionMenu(menuList2);
            }
        }
    }
}
