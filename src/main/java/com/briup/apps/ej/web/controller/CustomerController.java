package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.VM.CustomerDetailsVM;
import com.briup.apps.ej.bean.extend.CustomerExtend;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "顾客管理接口")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("queryAll")
    @ApiOperation("查询客户信息，返回列表数据")
    public Message queryAll(Long customerId,Long waiterId){
        List<CustomerExtend> list = customerService.queryAll(customerId,waiterId);
        return MessageUtil.success("success",list);
    }

    @GetMapping("queryDetails")
    @ApiOperation("查询订单信息，并且订单级联关键的属性")
    public Message queryDetails(Long customerId,Long waiterId){
        List<CustomerDetailsVM> list = customerService.queryDetails(customerId,waiterId);
        return MessageUtil.success("success",list);
    }


    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Customer customer){
        List<Customer> list=customerService.query(customer);

        return MessageUtil.success("success",list);
    }

    @ApiOperation("查找所有用户")
    @GetMapping("findAll")
    public Message findAll(){
        List<Customer> list = customerService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("保存（ID自动生成，请勿输入ID）或更新用户信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Customer customer) throws Exception{
            customerService.saveOrUpdate(customer);
            return MessageUtil.success("保存成功");
        }

    @ApiOperation("通过ID删除用户信息")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        try{
            customerService.deleteById(id);
            return MessageUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过ID查找用户信息")
    @GetMapping("selectById")
    public Message selectById(Long id){
        Customer customer = customerService.selectById(id);
        if(customer==null)
            return MessageUtil.error("用户不存在");
        else{
            return MessageUtil.success("查找成功",customer);
        }
    }
    @ApiOperation("批量删除（数据用“,”隔开）")
    @PostMapping("batchDelete")
    public Message batchDelete(long[] ids) throws Exception{
        customerService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
    @ApiOperation("用户封禁")
    @GetMapping("close")
    public Message close(Long id) throws Exception{
        if (customerService.close(id)==1)
          return MessageUtil.success("用户封禁成功");
        else
            return MessageUtil.error("封禁失败");
    }
    @ApiOperation("用户解封")
    @GetMapping("open")
    public Message open(Long id) throws Exception{
        if (customerService.open(id)==1)
            return MessageUtil.success("用户解封成功");
        else
            return MessageUtil.error("封禁失败");
    }
}
