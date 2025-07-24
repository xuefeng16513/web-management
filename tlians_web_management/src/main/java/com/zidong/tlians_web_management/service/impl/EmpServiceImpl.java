package com.zidong.tlians_web_management.service.impl;

import com.zidong.tlians_web_management.mapper.EmpMapper;
import com.zidong.tlians_web_management.pojo.Dept;
import com.zidong.tlians_web_management.pojo.Emp;
import com.zidong.tlians_web_management.pojo.pageBean;
import com.zidong.tlians_web_management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;


    @Override
    public pageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
            pageBean pageBean = new pageBean();
            pageBean.setTotal(empMapper.total());
            pageBean.setRows(empMapper.rows((page-1)*pageSize, pageSize, name, gender, begin, end));
            return pageBean;
    }

    @Override
    public void deleteByIds(List<Integer> idArray) {

        empMapper.deleteByIds(idArray);
    }

    @Override
    public void insertEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insertEmp(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
