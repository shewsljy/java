package cn.jiayuli.mybatis.ShellRunner;

import org.mybatis.generator.api.ShellRunner;

public class Runner {
    public static void main(String[] args) {
        String config = Runner.class.getClassLoader().getResource("mybatis-generator/generatorConfig.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
    }
}
