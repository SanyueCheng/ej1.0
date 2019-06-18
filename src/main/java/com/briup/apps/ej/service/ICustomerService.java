package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.VM.CustomerDetailsVM;
import com.briup.apps.ej.bean.extend.CustomerExtend;
import com.briup.apps.ej.utils.Message;

import java.util.List;
//测试 查询部抛出异常，增删改要抛出异常
public interface ICustomerService {
//查询顾客详情
    List<CustomerDetailsVM> queryDetails(Long  customerId,Long waiterId);
    //顾客级联查询
    List<CustomerExtend> queryAll(Long customerId,Long waiterId);

    List<Customer> findAll();

    // List<CustomerExample> query(CustomerExample customerExample);

    Customer selectById(Long id);

    List<Customer> query(Customer customer);

    int saveOrUpdate(Customer customer) throws Exception;

    int deleteById(Long id) throws  Exception;

    void batchDelete(long[] ids) throws Exception;

    int close(Long id) throws Exception;

    int open(Long id) throws Exception;

}

