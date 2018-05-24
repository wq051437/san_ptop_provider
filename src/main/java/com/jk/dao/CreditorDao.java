package com.jk.dao;

import com.jk.model.Creditor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by 左小山 on 2018/5/16.
 */@Mapper
public interface CreditorDao {

    List<Creditor> queryCreditorList(Creditor creditor);


//    @Select("select count(*) from t_zhaiquan where 1=1")
//    long queryCreditorPage();
//
//    @Select("select * from t_zhaiquan where 1=1  limit #{start},#{end}")
//    List<Creditor> queryCreditorList(@Param("start") int start, @Param("end") int end);
//userName like CONCAT('%', #{userName}, '%')  username and jiekuantitle  and startDateand endDate
   /* @Select("select * from t_zhaiquan where 1=1\n" +
            "\t\t  <if test=\"jiekuantitle != null and jiekuantitle != '' \">\n" +
            "\t\t and   jiekuantitle like  #{creditor.jiekuantitle}\n" +
            "\t\t  </if>")*/
//    @Select({"<script>",
//            "SELECT * FROM t_zhaiquan",
//            "WHERE 1=1",
//            "<when test='jiekuantitle!=null'>",
//            "AND jiekuantitle = #{creditor.jiekuantitle}",
//            "</when>",
//            "</script>"})
   // @SelectProvider(type=DemoSqlProvider.class,method="select5")
   // List<Creditor> queryCreditorPage(Creditor creditor);


   List<Creditor> queryCreditorPage(@Param("creditor") Creditor creditor);

   // long queryCreditorTotal(@Param("username")String username,@Param("jiekuantitleint") String jiekuantitleint,@Param("startDate") String startDate, @Param("endDate")String endDate,@Param("claimtype")Integer claimtype);
}
