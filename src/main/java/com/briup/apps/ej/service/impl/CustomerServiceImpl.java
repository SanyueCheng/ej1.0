package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.bean.VM.CustomerDetailsVM;
import com.briup.apps.ej.bean.extend.CustomerExtend;
import com.briup.apps.ej.dao.CustomerMapper;
import com.briup.apps.ej.dao.extend.CustomerExtendMapper;

import com.briup.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;
import com.briup.apps.ej.dao.extend.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Date;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private CustomerExtendMapper customerExtendMapper;


    @Override
    public List<CustomerDetailsVM> queryDetails(Long  customerId, Long waiterId){
        return customerExtendMapper.queryDetails(customerId,waiterId);
    }

    @Override
    public List<CustomerExtend> queryAll(Long customerId, Long waiterId){
        return customerExtendMapper.queryAll(customerId,waiterId);
    }

    @Override
    public List<Customer> findAll() {
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExample(example);
    }

    @Override
    public Customer selectById(Long id){
        return customerMapper.selectByPrimaryKey(id);

    }

    @Override
    public List<Customer> query(Customer customer) {
        CustomerExample example=new CustomerExample();
        //通过客户姓名模糊查询
        if (customer.getRealname()!=null){
            example.createCriteria().andRealnameLike("%"+customer.getRealname()+"%");

        }
        //通过客户电话模糊查询
        if (customer.getTelephone()!=null){
            example.createCriteria().andTelephoneLike("%"+customer.getTelephone()+"%");

        }

        return customerMapper.selectByExample(example);
    }


    @Override
    public int saveOrUpdate(Customer customer){
        //id自动生成
        if(customer.getId()== null) {
            customer.setStatus("正常");
            return customerMapper.insert(customer);
        }else {
            return customerMapper.updateByPrimaryKey(customer);
        }

    }


    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id : ids){
            customerMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public int deleteById(Long id) throws Exception{
        Customer customer=customerMapper.selectByPrimaryKey(id);
        if (customer == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return customerMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int close(Long id) throws Exception{
     Customer customer = customerMapper.selectByPrimaryKey(id);
     if(customer == null)
         throw new Exception("用户不存在");
     else
         return customerMapper.closeById(id);
    }

    @Override
    public int open(Long id) throws Exception{
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if(customer == null)
            throw new Exception("用户不存在");
        else
            return customerMapper.openById(id);
    }
}
