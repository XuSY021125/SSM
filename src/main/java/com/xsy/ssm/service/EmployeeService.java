package com.xsy.ssm.service;

import com.xsy.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    void addEmployee(Employee employee);

    void deleteEmployee(Integer empId);

    void updateEmployee(Employee employee);

    Employee get(Integer empId);
}
