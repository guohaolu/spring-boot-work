package com.stealandfire.service;

import com.stealandfire.pojo.dto.QualifySpecialListSaveDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class QualifySpecialListServiceTest {
    @Autowired
    private IQualifySpecialListService qualifySpecialListService;

    @Test
    void bachSave() {
        int batchCode = 1001;
        long userId = 3L;
        List<QualifySpecialListSaveDTO> saveDTOList = Stream.of(
                        new QualifySpecialListSaveDTO("00587923", "张三", false),
                        new QualifySpecialListSaveDTO("00825692", "李四", false))
                .collect(Collectors.toList());

        qualifySpecialListService.bachSave(batchCode, saveDTOList, userId);

    }
}