/**
 *
 * 查询管理员账户信息  验证管理员登录系统
 * @author chen ying
 */
package com.example.demo.repository.mapper;

import com.example.demo.domain.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
//管理员登陆  数据处理页面
@Mapper
@Service
public interface AdminMapper {
    //管理员登陆
    @Select("select * from admin where adminname=#{adminname}")
    public Admin  getAdminname(@Param("adminname") String adminusername);

    //管理员添加党员信息
    @Insert("insert into users (username,sex,minzu,jiguan,phone,idcard,birthday,work,education,address,rudangtime,people,zhibu,status,bianhao,zhibubianhao) " +
            "values (#{username},#{sex},#{minzu},#{jiguan},#{phone},#{idcard},#{birthday},#{work},#{education},#{address},#{rudangtime},#{people},#{zhibu},#{status},#{bianhao},#{zhibubianhao})")
    void numbersAdd(@Param("username") String  username,@Param("sex") String sex  ,@Param("minzu") String minzu ,

                    @Param("jiguan") String jiguan ,@Param("phone") String phone  ,@Param("idcard") String idcard  ,@Param("birthday") String birthday
            ,@Param("work") String work,@Param("education") String education,@Param("address") String address,
                    @Param("rudangtime") String rudangtime,@Param("people") String people,@Param("zhibu") String zhibu,
                    @Param("status") String status,@Param("bianhao") String bianhao,@Param("zhibubianhao") String zhibubianhao);
    //管理员删除党员信息
    @Delete("delete from users where bianhao = #{bianhao}")
    void numberDelete(@Param("bianhao") String bianhao);
    //修改党员信息

    @Update("update users  set username=#{username},sex=#{sex},minzu=#{minzu},jiguan=#{jiguan},phone=#{phone},idcard=#{idcard},birthday=#{birthday},work=#{work}" +
            ",education=#{education},address=#{address},rudangtime=#{rudangtime} ,people=#{people} ,zhibu=#{zhibu} ,status=#{status} ,zhibubianhao=#{zhibubianhao} where bianhao = #{bianhao}")
    void  updateNumber(@Param("username") String  username,@Param("sex") String sex  ,@Param("minzu") String minzu ,

                       @Param("jiguan") String jiguan ,@Param("phone") String phone  ,@Param("idcard") String idcard  ,@Param("birthday") String birthday
            ,@Param("work") String work,@Param("education") String education,@Param("address") String address,
                       @Param("rudangtime") String rudangtime,@Param("people") String people,@Param("zhibu") String zhibu,
                       @Param("status") String status,@Param("zhibubianhao") String zhibubianhao,@Param("bianhao") String bianhao);
//修改党员信息  用户修改
    @Update("update users  set username=#{username},sex=#{sex},minzu=#{minzu},jiguan=#{jiguan},phone=#{phone},idcard=#{idcard},birthday=#{birthday},work=#{work}" +
            ",education=#{education},address=#{address},rudangtime=#{rudangtime} ,people=#{people} ,zhibu=#{zhibu} ,status=#{status} ,bianhao = #{bianhao},zhibubianhao=#{zhibubianhao}  where phone=#{phone}")
    void  updateNumber1(@Param("username") String  username,@Param("sex") String sex  ,@Param("minzu") String minzu ,

                       @Param("jiguan") String jiguan ,@Param("phone") String phone  ,@Param("idcard") String idcard  ,@Param("birthday") String birthday
            ,@Param("work") String work,@Param("education") String education,@Param("address") String address,
                       @Param("rudangtime") String rudangtime,@Param("people") String people,@Param("zhibu") String zhibu,
                       @Param("status") String status,@Param("bianhao") String bianhao,@Param("zhibubianhao") String zhibubianhao,@Param("phone") String phone1);
}
