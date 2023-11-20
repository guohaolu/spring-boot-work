package com.stealandfire.service;

import com.stealandfire.pojo.dto.QualifySpecialListSaveDTO;

import java.util.List;

/**
 * 特殊名单service层服务接口
 */
public interface IQualifySpecialListService {
    /**
     * 批量保存
     *
     * @param batchCode 当前批次号
     * @param saveDTOList saveDTOList
     * @param userId 用户id
     */
    void bachSave(int batchCode, List<QualifySpecialListSaveDTO> saveDTOList, long userId);
}
