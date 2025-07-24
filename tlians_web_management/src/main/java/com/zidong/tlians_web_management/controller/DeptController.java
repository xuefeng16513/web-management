package com.zidong.tlians_web_management.controller;

import com.zidong.tlians_web_management.anno.Log;
import com.zidong.tlians_web_management.pojo.Dept;
import com.zidong.tlians_web_management.pojo.Result;
import com.zidong.tlians_web_management.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    // @RequestMapping("/depts")
    @GetMapping
    public Result list() {
        log.info("记录全部门日志");
        return Result.success(deptService.list());
    }

    @DeleteMapping("/{id}")
    @Log
    public Result delete(@PathVariable Integer id) {
        log.info("删除部门，并且删除部门下的所有员工");
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    @Log
    public Result insertByName(@RequestBody Dept dept) {
        log.info("增加部门");
        deptService.insert(dept);
        return Result.success();
    }

}
