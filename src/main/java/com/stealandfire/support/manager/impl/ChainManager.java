package com.stealandfire.support.manager.impl;

import com.stealandfire.pojo.Student;
import com.stealandfire.pojo.WorkFlowTodoItemsQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ChainManager {

    public List<Student> listTodoItems(WorkFlowTodoItemsQuery query) {
        // 通过高级查询条件调用dao
        // （1）Activiti框架表连接eflom表
        // （2）然后连接Jalor用户表和电子流用户表
        List<Student> students = listEflow(query);
        converterUserInfo(students, query);
        return students;
    }

    private List<Student> listEflow(WorkFlowTodoItemsQuery query) {
        // （1）Activiti框架表连接eflom表
        // 调用Dao方法
        return Collections.singletonList(new Student());
    }

    private void converterUserInfo(List<Student> students, WorkFlowTodoItemsQuery query) {
        List<Long> userIdList = students.stream().filter(Objects::nonNull).distinct().map(Student::getUserid).collect(Collectors.toList());
        // 通过userid回显用户信息,500一批
        // （1）listStudentByUserId,转为Map<userid, student>
        Map<Long, Student> userInfoMap = ListUtils.partition(userIdList, 500).stream().map(ids -> listStudentByUserId(ids, query)).flatMap(Collection::stream)
                .filter(Objects::nonNull).collect(Collectors.toMap(Student::getUserid, Function.identity(), (left, right) -> right));
        for (Student student : students) {
            Student target = userInfoMap.get(student.getUserid());
            // 通过target更新student，使用mapstruct
        }
        CollectionUtils.filter(students, stu -> userInfoMap.containsKey(stu.getUserid()));
    }

    private List<Student> listStudentByUserId(List<Long> userIdList, WorkFlowTodoItemsQuery query) {
        // 调用dao方法获取用户信息
        return Collections.singletonList(new Student());
    }

    // 通过审批编码、审批日期筛选
    // 显示审批内容
    private void converterViolation(List<Student> students, WorkFlowTodoItemsQuery query) {
        
    }
}
