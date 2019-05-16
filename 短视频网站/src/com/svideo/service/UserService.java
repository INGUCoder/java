package com.svideo.service;

import com.svideo.domain.Page;
import com.svideo.domain.PageBean;
import com.svideo.domain.TbUser;

public interface UserService {
    /**
     * 获得用户列表
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    PageBean<TbUser> getUserList(Integer currPage, Integer pageSize);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    boolean delTbUser(Long id);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    TbUser userLogin(TbUser user) throws Exception;

    /**
     * 通过用户名发现用户
     *
     * @param username
     * @return
     */
    boolean findUserByUserName(String username);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    TbUser updateUser(TbUser user);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int userRegister(TbUser user);
}
