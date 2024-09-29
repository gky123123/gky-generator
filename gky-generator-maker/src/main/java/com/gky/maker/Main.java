package com.gky.maker;

import com.gky.maker.cli.CommandExecutor;
import com.gky.maker.generator.main.GenerateTemplate;
import com.gky.maker.generator.main.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        GenerateTemplate generateTemplate = new MainGenerator();
        generateTemplate.doGenerate();
    }
}
