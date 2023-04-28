package com.example.other;

import java.util.Arrays;

public class P_cloud {

    public static void main(String[] args) {
        System.out.println(new P_cloud().step(new int[]{0,0,1,0,0,1,0}));
        System.out.println(new P_cloud().step(new int[]{0,0,0,0,1,0}));
        System.out.println(new P_cloud().step(new int[]{0,0}));
    }

    public int step(int[] nums){
        if (nums.length <= 1){
            return 0;
        }
        int len = nums.length;
        int[] tar = new int[len];

        for (int j = 1; j < len; j++) {
            if (nums[j] == 1){
                tar[j] = len;
                continue;
            }
            tar[j] = Math.min(j-2>=0?tar[j-2]:len,tar[j-1]) + 1;
        }
        return tar[len-1];
    }


    public int step1(int[] nums){
        int step=0,i = 1;
        int len = nums.length;

        while ( i < len ) {
            int n_1 = i + 1;
            int n_2 = i + 2;

            if (n_1 == len || n_2 == len){
                step++;
                break;
            }

            if (nums[n_2]==0){
                i= n_2;
                step ++;
                continue;
            }
            if (nums[n_1]==0){
                i= n_1;
                step ++;
                continue;
            }

        }
        return step;
    }

}
