package cn.jiayuli.allsome;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyBatisGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        //生成文件的输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //开发人员
        gc.setAuthor("jiayu");
        //是否打开输出目录
        gc.setOpen(false);
        //开启 swagger2 模式
        // gc.setSwagger2(true);
        //开启 Kotlin 模式
        //gc.setKotlin(false);
        //是否在xml中添加二级缓存配置
        //gc.setEnableCache(false);
        //开启 ActiveRecord 模式
        //gc.setActiveRecord(false);
        //时间类型对应策略
        // ONLY_DATE:只使用 java.util.date 代替
        // SQL_PACK:使用 java.sql 包下的
        // TIME_PACK:使用 java.time 包下的java8 新的时间类型
        gc.setDateType(DateType.TIME_PACK);
        //开启 BaseResultMap
        gc.setBaseResultMap(true);
        //开启 baseColumnList
        gc.setBaseColumnList(true);
        //是否覆盖已有文件
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //数据库类型
        dsc.setDbType(DbType.MYSQL);
        //驱动连接的URL
        dsc.setUrl("jdbc:mysql://localhost:3306/allsome?useUnicode=true&useSSL=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai");
        //数据库 schema name
        dsc.setSchemaName("allsome");
        //驱动名称
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //数据库连接用户名
        dsc.setUsername("allsome");
        //数据库连接密码
        dsc.setPassword("myallsome");
        mpg.setDataSource(dsc);

        // 表策略配置
        StrategyConfig strategy = new StrategyConfig();
        //是否大写命名
        strategy.setCapitalMode(false);
        //是否跳过视图
        strategy.setSkipView(false);
        //从数据库表到文件的命名策略
        // no_change:不做任何改变，原样输出
        // underline_to_camel:下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略
        // 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //表前缀
        strategy.setTablePrefix("t_");
        //字段前缀
        //strategy.setFieldPrefix("");
        //自定义继承的Entity类全称，带包名
        //strategy.setSuperEntityClass("");
        //自定义基础的Entity类，公共字段
        //strategy.setSuperEntityColumns("");
        //自定义继承的Mapper类全称，带包名，默认 com.baomidou.mybatisplus.core.mapper.BaseMapper
        //ConstVal.SUPER_MAPPER_CLASS
        //strategy.setSuperMapperClass("");
        //自定义继承的Service类全称，带包名，默认 com.baomidou.mybatisplus.extension.service.IService
        //ConstVal.SUPER_SERVICE_CLASS
        //strategy.setSuperServiceClass("");
        //自定义继承的ServiceImpl类全称，带包名，默认 com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
        //ConstVal.SUPER_SERVICE_IMPL_CLASS
        //自定义继承的Controller类全称，带包名
        //strategy.setSuperControllerClass("");
        //默认激活进行sql模糊表名匹配
        //关闭之后likeTable与notLikeTable将失效，include和exclude将使用内存过滤
        strategy.setEnableSqlFilter(true);
        //需要包含的表名，允许正则表达式（与exclude二选一配置） 当enableSqlFilter为true时，正则表达式无效.
        //strategy.setInclude("");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //需要排除的表名，允许正则表达式 当enableSqlFilter为true时，正则表达式无效.
        //strategy.setExclude("");
        //包含表名
        //strategy.setLikeTable(new LikeTable(""));
        //不包含表名
        //strategy.setNotLikeTable(new LikeTable(""));
        //实体是否生成 serialVersionUID
        strategy.setEntitySerialVersionUID(true);
        //实体是否生成字段常量
        //strategy.setEntityColumnConstant(false);
        //实体是否为链式模型
        strategy.setChainModel(false);
        //实体是否为lombok模型
        strategy.setEntityLombokModel(true);
        //Boolean类型字段是否移除is前缀
        //strategy.setEntityBuilderModel(false);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //驼峰转连字符
        //@RequestMapping("/managerUserActionHistory")
        // -> @RequestMapping("/manager-user-action-history")
        //strategy.setControllerMappingHyphenStyle(false);
        //是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(false);
        //乐观锁属性名称
        //strategy.setVersionFieldName("");
        //逻辑删除属性名称
        //strategy.setLogicDeleteFieldName("");
        //表填充字段
        //List<TableFill> tableFillList = new ArrayList<TableFill>();
        //tableFillList.add(new TableFill("user_id",FieldFill.DEFAULT));
        //strategy.setTableFillList(tableFillList);
        //
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("cn.jiayuli.allsome");
        //父包模块名
        //pc.setModuleName(scanner("模块名"));
        //Entity包名
        //pc.setEntity("");
        //Service包名
        //pc.setService("");
        //Service Impl包名
        //pc.setServiceImpl("");
        //Mapper包名
        //pc.setMapper("");
        //Mapper XML包名
        //pc.setXml("");
        //Controller包名
        //pc.setController("");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        //templateConfig.setEntity("templates/entity.java");
        templateConfig.setService(null);
        templateConfig.setController(null);
        templateConfig.setServiceImpl(null);
        //将模版中的xml设置为null，使得在java目录中不生成xml文件
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

}
