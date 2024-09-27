package com.gky.generator;

import com.gky.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //静态文件生成
        String projectPath = System.getProperty("user.dir");
        //输入路径 ACM 示例代码模板目录 gky-generator-demo-projects\acm-template
        String inputPath = projectPath + File.separator + "gky-generator-demo-projects" + File.separator + "acm-template";
        //输出路径：直接输出到项目的根目录
        //E:\Java\JavaProject\yupi\CodeGenerate\gky-generator
        String outputPath = projectPath;
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //动态文件替换
        String dynamicInputPath = projectPath + File.separator + "gky-generator-basic" + File.separator +"/src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/gky/acm/MainTemplate.java";
        //数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("gky");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
