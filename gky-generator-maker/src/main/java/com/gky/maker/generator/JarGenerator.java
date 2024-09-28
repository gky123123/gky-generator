package com.gky.maker.generator;

import java.io.*;

public class JarGenerator {

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
//        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String mavenCommand = "mvn.cmd clean package -DskipTests=true";
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        //打开终端的命令行
        Process process = processBuilder.start();
        //读取命令输出
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        int exitCode = process.waitFor();
        System.out.println("命令执行结束,提出码:" + exitCode);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("E:\\Java\\JavaProject\\yupi\\CodeGenerate\\gky-generator\\gky-generator-basic");
    }
}