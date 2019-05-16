package com.svideo.service;

import com.svideo.domain.TbAdmin;

public interface AdminService {

    /**
     * 用户登录
     *
     * @param tbAdmin
     * @return
     */
    TbAdmin adminLogin(TbAdmin tbAdmin) throws Exception;
}
