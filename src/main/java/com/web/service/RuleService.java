package com.web.service;

import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ruleService")
public class RuleService{
    @KSession("ksession")//注： 这里的值与配置文件中的值是一样的
    KieSession ksession;

    @KBase("kbase")//注： 这里的值与配置文件中的值是一样的
    KieBase kBase;

    @Autowired
    private KieBase kiebase;

    public String ruleKSession() {
        int count = ksession.fireAllRules();
        return "共执行了"+count+"规则";
    }

    public String ruleKBase() {
        KieSession kieSession = kBase.newKieSession();
        int count = kieSession.fireAllRules();
        return "共执行了"+count+"规则";
    }

    public String ruleAutowired() {
        KieSession kieSession = kiebase.newKieSession();
        int count = kieSession.fireAllRules();
        return "共执行了"+count+"规则";
    }
}
