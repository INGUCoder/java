package com.svideo.service.impl;

import com.svideo.domain.TbAdmin;
import com.svideo.domain.TbAdminExample;
import com.svideo.mapper.TbAdminMapper;
import com.svideo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TbAdminMapper tbAdminMapper;

    @Override
    public TbAdmin adminLogin(TbAdmin tbAdmin) throws Exception {
        TbAdminExample tbAdminExample = new TbAdminExample();
        TbAdminExample.Criteria criteria = tbAdminExample.createCriteria();
        criteria.andAdminNameEqualTo(tbAdmin.getAdminName());
        criteria.andPasswordEqualTo(tbAdmin.getPassword());
        List<TbAdmin> list = tbAdminMapper.selectByExample(tbAdminExample);
        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }
}
