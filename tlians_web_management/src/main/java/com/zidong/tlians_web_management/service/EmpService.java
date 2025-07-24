package com.zidong.tlians_web_management.service;

import com.zidong.tlians_web_management.pojo.Emp;
import com.zidong.tlians_web_management.pojo.pageBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
    pageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
    void deleteByIds(@RequestParam List<Integer> idArray);
    void insertEmp(Emp emp);
    Emp getById(Integer id);
    void updateEmp(Emp emp);
    Emp login(Emp emp);

}
