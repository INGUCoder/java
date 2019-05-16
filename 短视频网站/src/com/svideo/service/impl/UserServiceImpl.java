package com.svideo.service.impl;

import com.svideo.domain.Page;
import com.svideo.domain.PageBean;
import com.svideo.domain.TbUser;
import com.svideo.domain.TbUserExample;
import com.svideo.mapper.TbUserMapper;
import com.svideo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public PageBean<TbUser> getUserList(Integer currPage, Integer pageSize) {
        if (currPage == null) currPage = 1;

        if (pageSize == null) pageSize = 5;


        PageBean<TbUser> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currPage);
        pageBean.setPageSize(pageSize);
        //丛数据库中查询总记录数
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        /*criteria.andVideoNameLike(keyWord);*/
        Integer totalCount = (int) tbUserMapper.countByExample(example);

        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(pageBean.getTotalPage());
        int index = (currPage - 1) * pageSize;
        int end = index + pageSize;
        criteria.andIdBetween((long) index, (long) end);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);

        pageBean.setList(tbUsers);

        //分装
        return pageBean;
    }

    /**
     * 后台删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delTbUser(Long id) {
        try {
            tbUserMapper.deleteByPrimaryKey(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TbUser userLogin(TbUser user) throws Exception {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        /*criteria.andUsernameEqualTo(user.getUsername());*/
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        if (tbUsers.size() > 0) {
            return tbUsers.get(0);
        }
        return null;
    }

    @Override
    public boolean findUserByUserName(String username) {
        boolean flag = false;
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        /*criteria.andUsernameEqualTo(username);*/
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public TbUser updateUser(TbUser user) {
        TbUserExample example = new TbUserExample();
        int i = this.tbUserMapper.updateByPrimaryKey(user);
        TbUser userResult = null;
        if (i > 0) {
            TbUser tbUser = this.tbUserMapper.selectByPrimaryKey(user.getId());
            userResult = tbUser;
        }
        return userResult;
    }

    @Override
    public int userRegister(TbUser user) {
        return tbUserMapper.insertSelective(user);
    }
}
