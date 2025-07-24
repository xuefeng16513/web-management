package com.zidong.tlians_web_management.mapper;

import com.zidong.tlians_web_management.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp")
    Long total();

    // @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> rows(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    //@Delete("delete from emp where id in #{idArray}")
    void deleteByIds(List idArray);

    void insertEmp(Emp emp);

    Emp getById(Integer id);

    void updateEmp(Emp emp);

    Emp getByUsernameAndPassword(Emp emp);

    //根据部门ID删除部门下员工的数据
    @Delete ("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
