package com.zidong.tlians_web_management.service.impl;

import com.zidong.tlians_web_management.mapper.DeptMapper;
import com.zidong.tlians_web_management.mapper.EmpMapper;
import com.zidong.tlians_web_management.pojo.Dept;
import com.zidong.tlians_web_management.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return  deptMapper.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//交给spring进行事务管理
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
        // int a = 1/0;
        empMapper.deleteByDeptId(id);
    }

    @Override
    @Transactional//交给spring进行事务管理
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertDept(dept);
    }
}
