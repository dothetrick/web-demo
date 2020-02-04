package com.yourcom.proname.bin;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MPGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 工程的地址
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setActiveRecord(true);
        // 作者
        gc.setAuthor("dothetrick");
        gc.setOpen(false);
        // 是否覆盖原文件
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.jdbc.Driver");

        /*
            数据库的配置,修改为自己的
         */
        dsc.setUrl("jdbc:mysql://localhost:3306/test_db?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dsc.setUsername("test");
        dsc.setPassword("123456");

        // 手动指定字段类型的映射，在java8中，会将datetime类型映射为java的LocalDateTime，这里手动设置为Date类型
        dsc.setTypeConvert((ITypeConvert) (globalConfig, fieldType) -> {
            if (fieldType.toLowerCase().equals("datetime")) {
                return DbColumnType.DATE;
            }
            return new MySqlTypeConvert().processTypeConvert(globalConfig, fieldType);
        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.yourcom.proname.repository");
        pc.setEntity("entity.bizDb");
        pc.setMapper("mapper.bizDb");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 不生成xml文件，本示例工程使用无xml形式操作mysql
        templateConfig.setXml(null);
        // 不生成controller，需要生成的话，可以将这里注释掉
        templateConfig.setController(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 是否生成lombok形式的实体，需要项目中引入lombok
//        strategy.setEntityLombokModel(true);

        /*
          数据表名,修改为自己的表名，可写多个
         */
        strategy.setInclude("user");

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}


