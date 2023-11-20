package com.stealandfire.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualifySpecialListSaveDTO {
    /**
     * 员工输入工号
     */
    private String employeeNumber;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 是否有资格
     */
    private Boolean qualification;
}
