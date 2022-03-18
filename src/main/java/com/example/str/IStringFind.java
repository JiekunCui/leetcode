package com.example.str;

public interface IStringFind {

    int NOT_FOUND=-1;

    /**
     * 字符串定位，返回 target 在 content 中第一次出现的位置；
     * @param target 目标串
     * @param content 母串
     * @return 返回第一次出现的位置，未出现则返回 -1
     */
    int indexOf(String target,String content);
}
