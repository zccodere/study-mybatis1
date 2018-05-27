package com.zccoder.mybatis1.ch9.action.useenum;

/**
 * 标题：颜色枚举类<br>
 * 描述：颜色枚举类<br>
 * 时间：2018/05/25<br>
 *
 * @author zc
 **/
public enum Color {
    /** 红色 */
    RED(1,"红"),
    /** 黄色 */
    YELLOW(2,"黄"),
    /** 蓝色 */
    BLUE(3,"蓝");

    Color(int code,String name){
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Color getEnumByCode(int code){
        for (Color color : Color.values()) {
            if (color.code == code){
                return color;
            }
        }
        return null;
    }
}
