package com.gky.maker.model;

import lombok.Data;

/**
 * 静态模板配置
 */
@Data
public class DataModel {

    //作者
    private String author = "gky";

    //输出结果
    private String outputText = "结果：";

    //是否循环开关
    private boolean loop = false;
}
