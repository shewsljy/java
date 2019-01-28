package org.mybatis.generator.main;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisRunner {

    private static final Logger logger = LoggerFactory.getLogger(MybatisRunner.class);

    public static void main(String[] args){
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = null;
        Configuration config = null;
        DefaultShellCallback callback = null;
        MyBatisGenerator myBatisGenerator = null;
        InputStream configFile = null;
        String configFileName = "mybatis/generatorConfig.xml";

        try {
            configFile = MybatisRunner.class.getClassLoader().getResourceAsStream(configFileName);
            cp = new ConfigurationParser(warnings);
            config = cp.parseConfiguration(configFile);
            callback = new DefaultShellCallback(overwrite);
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        for (String warning : warnings){
            logger.info(warning);
        }
    }
}
