package com.web.controller;


import com.web.service.RuleService;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/rule")
public class RuleNameController {

    @Autowired
    private RuleService ruleService;

    @KSession("ksession")//注： 这里的值与配置文件中的值是一样的
    KieSession ksession;

    @RequestMapping(value = "/name")
    public String name(Model model) {
        String ruleKSession = ruleService.ruleKSession();
        String ruleKBase = ruleService.ruleKBase();
        String ruleAutowired = ruleService.ruleAutowired();
        model.addAttribute("ruleKSession", ruleKSession);
        model.addAttribute("ruleKBase", ruleKBase);
        model.addAttribute("ruleAutowired", ruleAutowired);
        return "showUser";
    }

    @RequestMapping(value = "/name2")
    public String name2(Model model) {
        model.addAttribute("ruleKSession", "在Controller层使用 @KSession执行规则"+ksession.fireAllRules());
        return "showUser";
    }
}
