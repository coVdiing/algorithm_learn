package com.vi.algorithm.demo;

//  迷宫寻路问题：用递归找出一条能抵达终点的路径
public class Maze {
    //  定义一个二维数组作为迷宫
    static int[][] arr = new int[7][7];

    public static void main(String[] args) {
        init();
        System.out.println("初始化迷宫");
        printMaze(arr);
        findWay(arr, 1, 1);
        System.out.println("寻路以后");
        printMaze(arr);
    }

    //  初始化迷宫，将墙的部分设置成1
    public static void init() {
        //  将第一行和第七行设置成墙壁
        for (int i = 0; i < 7; i++) {
            arr[0][i] = 1;
            arr[6][i] = 1;
        }

        //  将第一列和第六列设置成墙壁
        for (int j = 0; j < 7; j++) {
            arr[j][0] = 1;
            arr[j][6] = 1;
        }

        //  设置两个挡板
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[4][3] = 1;
//        arr[4][4] = 1;
        arr[4][5] = 1;
    }

    /**
     * 规定:
     * 1.坐标5,5是我们需要抵达的终点
     * 2.能走通的路，用2来表示，围墙用1表示，如果一条路走不通，我们用3表示这条路
     * 3.不对输入坐标进行判断，假设输入的数据都是合法的
     * 4.寻路的策略设定为:下 -> 右 -> 左 -> 上
     *
     * @param arr 目标迷宫
     * @param i   起始位置坐标
     * @param j   起始位置坐标
     */
    public static boolean findWay(int[][] arr, int i, int j) {
        // 递归结束条件：如果终点被改成1，说明已经抵达
        if (arr[5][5] == 2) {
            return true;
        } else {
            if (arr[i][j] == 0) {
                //  如果当前路径没有走过，假设当前坐标可以走通的，设置为2，如果不可以，之后再将其修改为3
                arr[i][j] = 2;
                if (findWay(arr, i + 1, j)) {
                    //  一直往下走找到了终点
                    return true;
                } else if (findWay(arr, i, j + 1)) {
                    //  往下走找不到路就会往右走
                    return true;
                } else if (findWay(arr, i, j - 1)) {
                    //  往右走找不到就会往左边走
                    return true;
                }
                else if (findWay(arr, i - 1, j)) {
                    //  往左边找不到就会往上走
                    return true;
                }
                //  四个方向走走到头了，说明这个点没有通路抵达终点
                arr[i][j] = 3;
            }
            return false;

        }
    }

    public static void printMaze(int[][] arr) {
        //  打印迷宫
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
