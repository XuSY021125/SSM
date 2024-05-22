package com.xsy.ssm.mapper;

import com.xsy.ssm.pojo.Employee;

import java.util.List;

/**
 * Date:2022/7/11
 * Author:ybc
 * Description:
 */
public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer empId);
    Employee get(Integer empId);
}
