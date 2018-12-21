package com.ruleString;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.kie.api.KieBase;
        import org.kie.api.cdi.KBase;
        import org.kie.api.cdi.KSession;
        import org.kie.api.runtime.KieSession;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Spring.xml"})
public class TestSpring {
    @KSession("ksession")//注： 这里的值与配置文件中的值是一样的
    KieSession ksession;

    @KBase("kbase")//注： 这里的值与配置文件中的值是一样的
    KieBase kBase;


    @KSession("ksessionRun")//注： 这里的值与配置文件中的值是一样的
    KieSession ksessionRun;
    @Test
    public void runRules() {
        int count = ksession.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ksession.dispose();
    }

    @Test
    public void runRulesKbase() {
        KieSession kieSession = kBase.newKieSession();
        int count = kieSession.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ksession.dispose();
    }


    @Test
    public void ruleRunTime() {
        int count = ksessionRun.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ksession.dispose();
    }
}
