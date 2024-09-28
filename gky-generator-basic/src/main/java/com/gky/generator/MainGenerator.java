package com.gky.generator;

import com.gky.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("gky");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        System.out.println(parentFile);
        // 输入路径
        String inputPath = new File(parentFile, "gky-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //动态文件替换 //+ "gky-generator-basic" + File.separator
        String dynamicInputPath = projectPath + File.separator +"/src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = outputPath + File.separator + "acm-template/src/com/gky/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, model);
    }
}



