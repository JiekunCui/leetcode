package com.example.leetcode;

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
public class P_0240_searchMatrix {

    static {
        int i = 1;
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.example.leetcode.P_0003_lengthOfLongestSubstring");

        int matrix[][] = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}};

        P_0240_searchMatrix minPathSum = new P_0240_searchMatrix();
        ClassLoader classLoader = P_0240_searchMatrix.class.getClassLoader();
        boolean searchMatrix = minPathSum.searchMatrix(matrix,56);

        System.out.println(searchMatrix);

    }


    public boolean searchMatrix(int[][] grid,int target) {
        int row = grid.length;
        if (row==0){return false;}
        int col = grid[0].length;
        if (col==0){return false;}
        int x=0,y=col-1;

        //从右上角开始查找
        while (x<row && y>=0){
            if ( grid[x][y] == target){
                return true;
            }else if (grid[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;

    }

}
