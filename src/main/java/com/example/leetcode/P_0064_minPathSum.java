package com.example.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * 
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0064_minPathSum {

    public static void main(String[] args) {

        int a[] = {2,7,11,15};
        int b[] = {-1,0};
        int c[] = {2,3,4,9,65,69};
        P_0064_minPathSum minPathSum = new P_0064_minPathSum();

        int pathSum = minPathSum.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});

        System.out.println(pathSum);

    }


    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row==0){return 0;}
        int col = grid[0].length;
        if (col==0){return 0;}

        int[][] tarGrid = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i==0 && j==0){ //左上角第一个元素
                    tarGrid[i][j] = grid[i][j];
                } else if (i==0){ // col[0]的元素
                    tarGrid[i][j] = grid[i][j] + tarGrid[i][j-1];
                }else if (j==0){  //row[0]的元素
                    tarGrid[i][j] = tarGrid[i-1][j] + grid[i][j];
                }else {
                    tarGrid[i][j] = Math.min( tarGrid[i-1][j],tarGrid[i][j-1]) + grid[i][j];
                }
            }
        }

        return tarGrid[row-1][col-1];

    }

}
