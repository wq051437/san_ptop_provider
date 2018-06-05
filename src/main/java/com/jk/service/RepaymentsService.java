package com.jk.service;


import com.alibaba.fastjson.JSONObject;
import com.jk.model.CollectionBean;
import com.jk.model.Personalloan;

import java.text.ParseException;
import java.util.List;

/**
 * Created by new鹏 on 2018/5/17.
 */
public interface RepaymentsService {
    JSONObject queryrepaymentslist(Integer offset, Integer limit, Personalloan personalloan2, String starttime, String endtime) throws ParseException;
    JSONObject queryrepaymentslist2(Integer offset, Integer limit, Personalloan personalloan2) throws ParseException;

    JSONObject queryrepaymentslist3(Integer offset, Integer limit, Personalloan personalloan2) throws ParseException;

    /**
     * 查询个人资料
     * @param userid
     * @return
     */
    List querylistgeren(Integer userid);


}
