package com.example.demo.dao;

import com.example.demo.model.Department;
import com.example.demo.model.DepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(DepartmentExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(DepartmentExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Department record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Department record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Department> selectByExample(DepartmentExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Department selectByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Department record);
}