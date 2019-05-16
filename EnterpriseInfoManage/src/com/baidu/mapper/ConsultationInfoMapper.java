package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.bean.ConsultationInfo;
import com.baidu.bean.EnterpriseInfo;

public interface ConsultationInfoMapper {
    List<ConsultationInfo> getConsultation(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
    
    Integer getLen();
}