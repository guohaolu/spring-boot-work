package com.stealandfire.support.manager.impl;

import com.stealandfire.common.annotation.EdmField;
import com.stealandfire.common.annotation.Table;
import com.stealandfire.support.manager.IAnimalManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
@Component
public class AnimalManager implements IAnimalManager {

    @Override
    public <T> void addAnimal(Supplier<List<T>> producer, Class<? extends T> type) {
        List<String> resultList = Lists.newArrayList();
        List<T> list = producer.get();
        Table table = AnnotationUtils.findAnnotation(type, Table.class);
        assert table != null;
        log.info("Adding {} {}s", list.size(), table.value());
        Map<String, EdmField> propertyMap = new HashMap<>();
        ReflectionUtils.doWithFields(type, field -> {
            EdmField edmField = AnnotationUtils.findAnnotation(field, EdmField.class);
            if (edmField != null) {
                propertyMap.put(field.getName(), edmField);
                log.info("field {}", edmField.value());
            }
        });
        for (T item : list) {
            BeanWrapper wrapper = new BeanWrapperImpl(item);
            propertyMap.forEach((property, edmField) -> {
                String edmStr = (String) wrapper.getPropertyValue(property);
                if (edmStr == null) {
                    resultList.add("");
                    return;
                }
                resultList.addAll(Arrays.asList(edmStr.split(";")));
            });
        }

        System.out.println(resultList);
    }
}
