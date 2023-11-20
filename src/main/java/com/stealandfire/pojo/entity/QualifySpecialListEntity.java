package com.stealandfire.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 特殊名单实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualifySpecialListEntity {
    /**
     * 特殊名单序号
     */
    private Integer specialListId;

    /**
     * 批次号
     */
    private Integer batchCode;

    /**
     * 员工Id
     */
    private Long personId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 是否有资格
     */
    private Boolean qualification;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 最后修改人
     */
    private Long updatedBy;

    /**
     * 最后修改时间
     */
    private Date updateDate;
}
