package com.stealandfire.support.manager.impl;

import com.stealandfire.support.manager.ITemplateManager;
import org.springframework.stereotype.Component;

@Component
public class UserTemplateManager implements ITemplateManager {
    @Override
    public void print() {
        System.out.println("user");
    }
}
