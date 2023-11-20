package com.stealandfire.pojo.entity;

import com.stealandfire.common.annotation.EdmField;
import com.stealandfire.common.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工工号信息表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("employee_number_t")
public class EmployeeNumberEntity {
    /**
     * 员工id
     */
    private Long personId;

    /**
     * 员工姓名
     */
    @EdmField("employee_name")
    private String employeeName;

    /**
     * 员工最新工号
     */
    @EdmField("employee_latest_number")
    private String employeeLatestNumber;

    /**
     * 员工上次工号
     */
    private String employeeLastNumber;
}
