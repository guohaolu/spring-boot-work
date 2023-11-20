# README

* [Introduction](#introduction)

## Introduction

### 1 设计模式

#### （1） Composite模式

在Spring中通过`@Autowired`注解使用
```java
@Component
public class CompositeTemplateManager implements ITemplateManager {
    @Autowired
    private List<ITemplateManager> managers;

    @Override
    public void print() {
        for (ITemplateManager manager : managers) {
            manager.print();
        }
    }
}
```

### 2 Activiti工作流

[activiti官方文档](https://activiti.gitbook.io/activiti-7-developers-guide/getting-started/getting-started-activiti-core)

`Activiti版本：7.1.0.M2`

#### TaskRuntime API
```java
// 启动流程
ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");

// 查询流程实例
List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().list();

// 查询流程实例
ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId("123").singleResult();

// 查询流程定义
ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("myProcess").singleResult();