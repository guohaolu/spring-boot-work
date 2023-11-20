package com.stealandfire.service.impl;

import com.stealandfire.dao.IEmployeeNumberDao;
import com.stealandfire.dao.IQualifySpecialListDao;
import com.stealandfire.pojo.dto.QualifySpecialListSaveDTO;
import com.stealandfire.pojo.entity.QualifySpecialListEntity;
import com.stealandfire.service.IQualifySpecialListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class QualifySpecialListService implements IQualifySpecialListService {
    @Autowired
    private IEmployeeNumberDao employeeNumberDao;

    @Autowired
    private IQualifySpecialListDao qualifySpecialListDao;
    private QualifySpecialListSaveDTO tempSaveDTO;

    @Override
    public void bachSave(int batchCode, List<QualifySpecialListSaveDTO> saveDTOList, long userId) {
        // TODO saveDTO -> employeeNumber -> personId
        // 从QualifySpecialListSaveDTO转为employeeNumber
        List<String> employeeNumberList = saveDTOList.stream()
                .map(QualifySpecialListSaveDTO::getEmployeeNumber)
                .collect(Collectors.toList());
        // employeeNumberList -> personIdList
        List<Long> personIdList = employeeNumberDao.listPersonIdByEmployeeLatestNumber(employeeNumberList);
        List<QualifySpecialListEntity> entityList = saveDTOListAndPersonIdList2EntityList(saveDTOList, personIdList, batchCode);
        entityList.forEach(System.out::println);
        qualifySpecialListDao.insertOrUpdate(entityList);
    }

    /**
     * saveDTO列表和员工id列表转成Entity列表
     *
     * @param saveDTOList  saveDTO列表
     * @param personIdList 员工id列表
     * @param batchCode    当前批次号
     * @return List
     */
    private List<QualifySpecialListEntity> saveDTOListAndPersonIdList2EntityList(final List<QualifySpecialListSaveDTO> saveDTOList, final List<Long> personIdList, int batchCode) {
        List<QualifySpecialListEntity> entityList = new ArrayList<>(saveDTOList.size());
        Map<Long, QualifySpecialListSaveDTO> personIdSaveDTOMap = IntStream.range(0, saveDTOList.size())
                .collect(HashMap::new,
                        (result, element) -> result.put(personIdList.get(element), saveDTOList.get(element)),
                        (m, n) -> {
                        });
        QualifySpecialListEntity tempEntity;
        QualifySpecialListSaveDTO tempSaveDTO;
        for (Map.Entry<Long, QualifySpecialListSaveDTO> entry : personIdSaveDTOMap.entrySet()) {
            tempSaveDTO = entry.getValue();
            tempEntity = new QualifySpecialListEntity();
            tempEntity.setPersonId(entry.getKey());
            tempEntity.setQualification(tempSaveDTO.getQualification());
            tempEntity.setEmployeeName(tempSaveDTO.getEmployeeName());
            tempEntity.setBatchCode(batchCode);
            entityList.add(tempEntity);
        }
        return entityList;
    }

}
