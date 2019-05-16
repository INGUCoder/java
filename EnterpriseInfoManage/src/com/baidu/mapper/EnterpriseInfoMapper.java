package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.bean.EnterpriseInfo;

public interface EnterpriseInfoMapper {
    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(EnterpriseInfo record);

    EnterpriseInfo selectByPrimaryKey(Integer enterpriseId);

    int updateByPrimaryKey(EnterpriseInfo record);
    
    List<EnterpriseInfo> getAllEnterprise();
	
    List<EnterpriseInfo> getEnterprise(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize,@Param("enterpriseName")String enterpriseName);
    
    Integer getLen(@Param("enterpriseName")String enterpriseName);
    
}