package com.stealandfire.support.manager;

import com.google.common.collect.Lists;
import com.stealandfire.pojo.entity.EmployeeNumberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IAnimalManagerTest {
    @Autowired
    private IAnimalManager animalManager;

    @Test
    void addAnimal() {
        EmployeeNumberEntity entity1 = new EmployeeNumberEntity();
        entity1.setEmployeeName("test1");
        entity1.setEmployeeLatestNumber("123456;sdasda;dsa");
        entity1.setEmployeeLastNumber("123;6454");
        entity1.setPersonId(1L);
        EmployeeNumberEntity entity2 = new EmployeeNumberEntity();
        entity2.setEmployeeName("test2");
        entity2.setEmployeeLatestNumber("q;w;e");
        entity2.setEmployeeLastNumber(null);
        entity2.setPersonId(2L);
        EmployeeNumberEntity entity3 = new EmployeeNumberEntity();
        entity3.setEmployeeName("test3");
        entity3.setEmployeeLatestNumber(null);
        entity3.setEmployeeLastNumber("   ");
        entity3.setPersonId(3L);

        List<EmployeeNumberEntity> list = Lists.newArrayList(entity1, entity2, entity3);
        animalManager.addAnimal(() -> list, EmployeeNumberEntity.class);
    }
}