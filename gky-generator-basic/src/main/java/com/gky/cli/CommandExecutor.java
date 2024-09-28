package com.gky.cli;

import com.gky.cli.commond.ConfigCommand;
import com.gky.cli.commond.GenerateCommand;
import com.gky.cli.commond.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "gky", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        //不输入子命令给出提示
        System.out.println("请输入具体命令,或者输入 --help 查看命令提示");
    }

    public Integer doExecute(String[] args){
        return commandLine.execute(args);
    }
}
