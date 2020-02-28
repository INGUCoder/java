package com.carbuybuy.carbuybuy.mapper;

import com.carbuybuy.carbuybuy.entity.Orders;

import java.util.List;

public interface OrdersMapper {

    List<Orders> selectAll();

    Orders selectById(Integer id);

    void insert(Orders orders);
}
