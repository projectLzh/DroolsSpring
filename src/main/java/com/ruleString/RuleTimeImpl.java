package com.ruleString;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

public class RuleTimeImpl implements RuleRuntimeEventListener {
    public void objectInserted(ObjectInsertedEvent event) {
        System.out.println("输出Insert监听方法");
    }

    public void objectUpdated(ObjectUpdatedEvent event) {
        String name = event.getOldObject().toString();
        System.out.println("输出Update监听方法"+name);
    }

    public void objectDeleted(ObjectDeletedEvent event) {
        System.out.println("输出Delete监听方法");
    }
}
