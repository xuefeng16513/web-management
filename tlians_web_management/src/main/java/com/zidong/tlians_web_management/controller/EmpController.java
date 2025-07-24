package com.zidong.tlians_web_management.controller;

import com.zidong.tlians_web_management.anno.Log;
import com.zidong.tlians_web_management.pojo.Dept;
import com.zidong.tlians_web_management.pojo.Emp;
import com.zidong.tlians_web_management.pojo.Result;
import com.zidong.tlians_web_management.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询员工");
        return Result.success(empService.list(page,pageSize, name,gender,begin,end));
    }

    @DeleteMapping("/{ids}")
    @Log
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        log.info("批量删除员工");
        empService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    @Log
    public Result insert(@RequestBody Emp emp) {
        log.info("添加员工");
        empService.insertEmp(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工");
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping()
    @Log
    public Result updateEmp(@RequestBody Emp emp){
        log.info ("修改员工");
        empService.updateEmp(emp);
        return Result.success();
    }


}
