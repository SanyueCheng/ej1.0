package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.VM.CustomerDetailsVM;
import com.briup.apps.ej.bean.extend.CustomerExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerExtendMapper {
    List<CustomerExtend> queryAll(
        @Param("customerId") Long customerId,
        @Param("waiterId") Long waiterId
    );
    List<CustomerDetailsVM> queryDetails(
        @Param("customerId") Long customerId,
        @Param("waiterId") Long waiterId
    );
}
