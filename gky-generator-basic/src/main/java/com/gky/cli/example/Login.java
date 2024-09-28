package com.gky.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true)
    String password;

    @Option(names = {"-cp", "--checkPassword"}, description = "Check Password", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class loginClass = Class.forName("com.gky.cli.example.Login");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-u").append(",").append("123456").append(",");
        Field[] fields = loginClass.getDeclaredFields();
        for (Field field : fields){

            Option annotation = field.getAnnotation(Option.class);
            if (!annotation.names()[0].equals("-u")){
                stringBuilder.append(annotation.names()[0]);
                stringBuilder.append(",");
            }
        }
        String str = stringBuilder.toString();
        args = str.split(",");
        System.out.println(Arrays.toString(args));
        new CommandLine(new Login()).execute(args);
    }


}
