package com.carbuybuy.carbuybuy.mapper;

import com.carbuybuy.carbuybuy.entity.Cars;

import java.util.List;

public interface CarsMapper {
    List<Cars> selectAll();
    Cars selectById(Integer id);
    List<Cars> selectByTypes(Integer types);
}
