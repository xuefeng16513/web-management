package com.zidong.tlians_web_management.service;

import com.zidong.tlians_web_management.pojo.Dept;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface DeptService {
    List<Dept> list();
    void deleteById(@PathVariable Integer id);
    void insert(Dept dept);
}
