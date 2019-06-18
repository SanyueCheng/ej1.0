package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    //详细信息查看
    Product selectById(Long id);
//产品信息更改或者新增产品信息
    int saveOrUpdate(Product product) throws Exception;
//单个删除
    int deleteById(Long id) throws  Exception;
 //批量删除
 void batchDelete(Long[] ids) throws Exception;


}
