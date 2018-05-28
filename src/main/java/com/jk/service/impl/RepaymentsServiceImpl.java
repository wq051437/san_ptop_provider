package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.RepaymentsDao;
import com.jk.model.Personalloan;
import com.jk.service.RepaymentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by new鹏 on 2018/5/17.
 */
@Service("repaymentsService")
public class RepaymentsServiceImpl  implements RepaymentsService{

    @Resource
    private RepaymentsDao repaymentsDao;

    @Override
    public JSONObject queryrepaymentslist(Integer offset, Integer limit, Personalloan personalloan2, String starttime, String endtime) throws ParseException {
        long   b=0;
        long   count=0;
        List<Personalloan> list = repaymentsDao.getrepaymentslist(offset,limit, personalloan2,starttime,endtime);
        List<Personalloan>   list2=new ArrayList<Personalloan>();
        for (Personalloan personalloan : list) {
            if (!personalloan.getHandletime().equals("0")){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String data = personalloan.getHandletime();
                String dataStr[] = data.split("-");
                //年份
                int year = (Integer.parseInt(dataStr[1]) + personalloan.getLoanmonth())/12;
                //月份
                int yue = (Integer.parseInt(dataStr[1]) + personalloan.getLoanmonth())%12;
                String a = "";
                if(yue<10){
                    if(yue<1){
                        a = "12";
                    }else{
                        a = "0"+yue;
                    }
                }else {
                    a = yue+"";
                }
                dataStr[0]=String.valueOf(Integer.parseInt(dataStr[0]) + year);
                dataStr[1]=a;
                String newdata = dataStr[0]+"-"+dataStr[1]+"-"+dataStr[2];
                Date newDate = format.parse(newdata);
                String data2 = format.format(new Date());
                String dataStr2[] = data2.split("-");
                //年份
                int year2 = (Integer.parseInt(dataStr2[1]) +1)/12;
                //月份
                int yue2 = (Integer.parseInt(dataStr2[1]) +1)%12;
                String a2 = "";
                if(yue2<10){
                    if(yue2<1){
                        a2 = "12";
                    }else{
                        a2 = "0"+yue2;
                    }
                }else {
                    a2 = yue2+"";
                }
                dataStr2[0]=String.valueOf(Integer.parseInt(dataStr2[0]) + year2);
                dataStr2[1]=a2;
                String newdata2 = dataStr2[0]+"-"+dataStr2[1]+"-"+dataStr2[2];
                Date newDate2 = format.parse(newdata2);
                Date newDate3 = new Date();
                //newDate2 是当前时间后一个月的1529769600000    1529769600000
                //newDate3 是当前时间1527124377864     1527124498503
                //newDate  是还款日期1527609600000   1530288000000
                if(newDate3.getTime() <= newDate.getTime()){
                    if(  newDate.getTime()<= newDate2.getTime()){
                        long  day=(newDate.getTime()-newDate3.getTime())/(24*60*60*1000);
                        personalloan.setSurplusday(day+1);
                        personalloan.setRepaymenttime(format.format(newDate));
                        b+=personalloan.getLoanmoney();
                        list2.add(personalloan);
                        count++;
                    }
                }
            }
        }
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list2);
        json.put("b",b);
        return json;
    }

    @Override
    public JSONObject queryrepaymentslist2(Integer offset, Integer limit, Personalloan personalloan2) throws ParseException {
        long   b2=0;
        long count=0;
        List<Personalloan> list = repaymentsDao.getrepaymentslist2(offset,limit,personalloan2);
        List<Personalloan>   list2=new ArrayList<Personalloan>();
        for (Personalloan personalloan : list) {
            if (!personalloan.getHandletime().equals("0")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String data = personalloan.getHandletime();
                String dataStr[] = data.split("-");
                //年份
                int year = (Integer.parseInt(dataStr[1]) + personalloan.getLoanmonth())/12;
                //月份
                int yue = (Integer.parseInt(dataStr[1]) + personalloan.getLoanmonth())%12;
                String a = "";
                if(yue<10){
                    if(yue<1){
                        a = "12";
                    }else{
                        a = "0"+yue;
                    }
                }else {
                    a = yue+"";
                }
                dataStr[0]=String.valueOf(Integer.parseInt(dataStr[0]) + year);
                dataStr[1]=a;
                String newdata = dataStr[0]+"-"+dataStr[1]+"-"+dataStr[2];
                Date newDate = format.parse(newdata);
                //还款日期
                String data2 = format.format(new Date());
                String dataStr2[] = data2.split("-");
                //年份
                int year2 = (Integer.parseInt(dataStr2[1]) -1)/12;
                //月份
                int yue2 = (Integer.parseInt(dataStr2[1]) -1)%12;
                String a2 = "";
                if(yue2<10){
                    if(yue2<1){
                        a2 = "12";
                    }else{
                        a2 = "0"+yue2;
                    }
                }else {
                    a2 = yue2+"";
                }
                dataStr2[0]=String.valueOf(Integer.parseInt(dataStr2[0]) + year2);
                dataStr2[1]=a2;
                String newdata2 = dataStr2[0]+"-"+dataStr2[1]+"-"+dataStr2[2];
                Date newDate2 = format.parse(newdata2);
                //当前时间前一个月
                Date newDate3 = new Date();
                if( newDate2.getTime()<= newDate.getTime()){
                    if(  newDate.getTime()<= newDate3.getTime() ){
                        long  day=(newDate3.getTime()-newDate.getTime())/(24*60*60*1000);
                        personalloan.setSurplusday(day+1);
                        personalloan.setRepaymenttime(format.format(newDate));
                        b2+=personalloan.getLoanmoney();
                        count++;
                        list2.add(personalloan);
                    }
                }
            }
        }
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list2);
        json.put("b2",b2);
        return json;
    }

    @Override
    public JSONObject queryrepaymentslist3(Integer offset, Integer limit, Personalloan personalloan2) throws ParseException {
        long  b3=0;
        long count=0;
        List<Personalloan> list = repaymentsDao.getrepaymentslist3(offset,limit,personalloan2);
        List<Personalloan>   list2=new ArrayList<Personalloan>();
        for (Personalloan personalloan : list) {
            if (!personalloan.getHandletime().equals("0")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String data = personalloan.getHandletime();
                String dataStr[] = data.split("-");
                //年份
                int year = (Integer.parseInt(dataStr[1]) + personalloan.getLoanmonth())/12;
                //月份
                int yue = (Integer.parseInt(dataStr[1]) + personalloan.getLoanmonth())%12;
                String a = "";
                if(yue<10){
                    if(yue<1){
                        a = "12";
                    }else{
                        a = "0"+yue;
                    }
                }else {
                    a = yue+"";
                }
                dataStr[0]=String.valueOf(Integer.parseInt(dataStr[0]) + year);
                dataStr[1]=a;
                String newdata = dataStr[0]+"-"+dataStr[1]+"-"+dataStr[2];
                Date newDate = format.parse(newdata);
                //还款日期
                String data2 = format.format(new Date());
                String dataStr2[] = data2.split("-");
                //年份
                int year2 = (Integer.parseInt(dataStr2[1]) -1)/12;
                //月份
                int yue2 = (Integer.parseInt(dataStr2[1]) -1)%12;
                String a2 = "";
                if(yue2<10){
                    if(yue2<1){
                        a2 = "12";
                    }else{
                        a2 = "0"+yue2;
                    }
                }else {
                    a2 = yue2+"";
                }
                dataStr2[0]=String.valueOf(Integer.parseInt(dataStr2[0]) + year2);
                dataStr2[1]=a2;
                String newdata2 = dataStr2[0]+"-"+dataStr2[1]+"-"+dataStr2[2];
                Date newDate2 = format.parse(newdata2);
                //当前时间前一个月
                Date newDate3 = new Date();
                if( newDate.getTime()<= newDate2.getTime()){
                    long  day=(newDate3.getTime()-newDate.getTime())/(24*60*60*1000);
                    personalloan.setSurplusday(day+1);
                    personalloan.setRepaymenttime(format.format(newDate));
                    b3+=personalloan.getLoanmoney();
                    count++;
                    list2.add(personalloan);
                }
            }
        }
        JSONObject json =new JSONObject();
        json.put("total", count);
        json.put("rows", list2);
        json.put("b3",b3);
        return json;
    }
}
