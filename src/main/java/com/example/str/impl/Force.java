package com.example.str.impl;

import com.example.str.IStringFind;

public class Force implements IStringFind {

    @Override
    public int indexOf(String target, String content) {

        if (target==null || content == null){
            return NOT_FOUND;
        }

        if (target.length() > content.length()){
            return NOT_FOUND;
        }

        int i=0,j=0,tLen=target.length(),cLen=content.length();

        for (; i < cLen && j <  tLen ; i++) {
            if (target.charAt(j) == content.charAt(i)){
                j++;
            }else {
                i=i-j +1;
                j=0;
            }
        }

       // if (j==)

        return 0;
    }
}
