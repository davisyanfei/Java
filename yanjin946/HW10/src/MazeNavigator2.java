import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * HW 10 - mazeNavigator
 *
 * <p> Purdue University -- CS 180 -- 2021</p>
 *
 * @author Jin Yan Purdue CS
 *
 * @version Nov 3rd, 2021
 */

public class MazeNavigator2 extends Thread {
    private static int currentRow = 4 ; //设置当前行数，，在静态区代码段，开辟一个常量4，给currentRow赋这个常量4的地址
    private static int currentColumn = 4 ; //设置当前列数
    private static int moveNumber = 0 ; //设置当前是第几步
    private static boolean started = false;
    private static char[][] maze = new char[10][10]; //设置迷宫格的大小
    private int playerNumber; //设置游戏玩家
    private String fileName; //设置文件


    public MazeNavigator2(int playerNumber, String fileName) {
        this.playerNumber = playerNumber;
        this.fileName = fileName;
    }

    public void run() { //要跑的程序
        if (playerNumber == 1) {  //当是第一个玩家的时候  程序的逻辑是先出牌的那个人，不一定是playerone？？？
            System.out.println("Welcome! Initial Maze:"); //print welcome message

            for (int i = 0; i < 10; i++) { //当行数小于10时，i循环
                System.out.print("["); //打印 【
                for (int j = 0; j < 10; j++) { //当列数小于10时，j循环
                    if (i == currentRow && j == currentColumn) { //当i是当前行数而且j是当前列数时
                        System.out.print("X"); //打印 X
                    } else { //其他情况时
                        System.out.print(" "); //打印空格
                    }
                    if (j < 9) { //当列数小于9时
                        System.out.print(","); //打印逗号
                    }
                }
                System.out.println("]"); //打印 】
            }
        }

        try {
            ArrayList<Integer> list1 = new ArrayList<Integer>(); //创建arraylist
            File f1 = new File(fileName); //创建file
            FileReader fr1 = new FileReader(f1); //读取file
            BufferedReader bfr1 = new BufferedReader(fr1);
            String line = bfr1.readLine(); //读每一行
            while (line!= null) { //当文件里有内容时
                int i = Integer.parseInt(line); //转换内容成int
                list1.add(i); //把内容加到arraylist里面
                line = bfr1.readLine();
            }
            bfr1.close();

            for(int i = 0; i < list1.size(); i++) { //当i在arraylist里面时
                int number = list1.get(i); //get i
                move(number, playerNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void move (int num, int playerNumber) {
        moveNumber ++; //游戏次数加一

        System.out.println("Move Number:" + moveNumber); //打印游戏次数
        System.out.println("Player: " + playerNumber); //打印当前玩家

        if (num == 1) { //当这个数是1时
            if (currentColumn == 0) { //当当前行数是0
                currentColumn = 9; //设置当前行数为9
            } else { //其他情况
                currentColumn --; //当前行数-1
            }
            System.out.println("Move: Left"); //打印 move left
        } else if (num == 2) { //当这个数是2时
            if (currentColumn == 9) { //当当前行数是9
                currentColumn = 0; //设置当前行数为0
            } else { //其他情况
                currentColumn ++; //当前行数+1
            }
            System.out.println("Move: Right"); //打印 move right
        } else if (num == 3) { //当这个数是3时
            if (currentRow == 0) { //如果当前列数是0
                currentRow = 9; //设置当前列数为9
            } else { //其他情况
                currentRow --; //当前列数-1
            }
            System.out.println("Move: Up"); //打印 move up
        } else if (num == 4) { //如果这个数是4时
            if (currentRow == 9) { //如果当前列数是9
                currentRow = 0; //设置当前列数为0
            } else { //其他情况
                currentRow ++; //当前列数+1
            }
            System.out.println("Move: Down"); //打印 move down
        } else { //如果不是1，2，3，4
            System.out.println("Error, invalid input!"); //打印 error message
        }

        for(int i = 0; i < 10; i++){
            System.out.print("[");
            for (int j= 0; j < 10; j++){
                if(i == currentRow && j == currentColumn) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
                if (j < 9) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }

    }

}