package com.stealandfire.support.manager.impl;

import com.stealandfire.support.manager.ITemplateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
