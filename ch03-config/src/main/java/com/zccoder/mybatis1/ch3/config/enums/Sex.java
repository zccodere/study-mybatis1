package com.zccoder.mybatis1.ch3.config.enums;

/**
 * <br>
 * 标题：性别枚举<br>
 * 描述：对应数据库字段<br>
 *
 * @author zc
 * @date 2018/03/16
 **/
public enum Sex {

    /**
     * 数据字典
     */
    MALE(1, "男"),
    /**
     * 数据字典
     */
    FEMALE(2, "女");

    private int id;
    private String name;

    private Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Sex getSex(int id) {
        for (Sex sex : Sex.values()) {
            if (sex.id == id) {
                return sex;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
