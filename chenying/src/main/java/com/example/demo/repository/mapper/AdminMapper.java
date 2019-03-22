/**
 *
 * 查询管理员账户信息  验证管理员登录系统
 * @author chen ying
 */
package com.example.demo.repository.mapper;

import com.example.demo.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
//管理员登陆  数据处理页面
@Mapper
@Service
public interface AdminMapper {
    //管理员登陆
    @Select("select * from admin where adminname=#{adminname}")
    public Admin  getAdminname(@Param("adminname") String adminusername);
}
