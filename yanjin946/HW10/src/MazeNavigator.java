import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * HW 10 - maze
 *
 * <p> Purdue University -- CS 180 -- 2021</p>
 *
 * @author Jin Yan Purdue CS
 *
 * @version Nov 3rd, 2021
 */

public class MazeNavigator extends  Thread{
    private static int currentRow = 4 ;
    private static int currentColumn = 4 ;
    private static int moveNumber = 0 ;
    private static boolean started = false;
    private static char[][] maze = new char[10][10];
    private int playerNumber;
    private  String fileName;

    public MazeNavigator(int playerNumber, String fileName){
        this.playerNumber = playerNumber;
        this.fileName = fileName;
    }
    public void a(){
        System.out.println("test a:");
    }
    public void run() {
/*      if (playerNumber == 1) {   //如果在这个地方进行初始化，那么是必须第一个人才能初始化，这个不符合题意的，如果是第二个人先下呢？
          //如果第二个人的线程先开始，本if语句内的内容就不会先运行。而先执行了下面try的block里边的语句。 这样前两个图会对不上。
          System.out.println("Welcome! Initial Maze:");

          for (int i = 0; i < 10; i++) {
              System.out.print("[");
              for (int j = 0; j < 10; j++) {
                  if (i == currentRow && j == currentColumn) {
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
      }*/
        try {
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            File f1 = new File(fileName);
            FileReader fr1 = new FileReader(f1);
            BufferedReader bfr1 = new BufferedReader(fr1);
            String line = bfr1.readLine();
            while (line!= null) {
                int i = Integer.parseInt(line);
                list1.add(i);
                line = bfr1.readLine();
            }
            bfr1.close();

            for(int i = 0; i < list1.size(); i++) {
                int number = list1.get(i);
                move(number, playerNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*    传入参数： num 1234为左右上下，playernumber 是用户号
    线程同步，需要保护的内存变量为：对当前位置currentColumn row和修改步数 movenumber 三个变量 */
    public static synchronized void move (int num, int playerNumber) {
        moveNumber ++;
        if (moveNumber == 1) {
            System.out.println("Welcome! Initial Maze:");
            for (int i = 0; i < 10; i++) {
                System.out.print("[");
                for (int j = 0; j < 10; j++) {
                    if (i == currentRow && j == currentColumn) {
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


        System.out.println("Move Number:" + moveNumber);
        System.out.println("Player: " + playerNumber);

        if (num == 1) {
            if (currentColumn == 0) {
                currentColumn = 9;
            } else {
                currentColumn --;
            }
            System.out.println("Move: Left");
        } else if (num == 2) {
            if (currentColumn == 9) {
                currentColumn = 0;
            } else {
                currentColumn ++;
            }
            System.out.println("Move: Right");
        } else if (num == 3) {
            if (currentRow == 0) {
                currentRow = 9;
            } else {
                currentRow --;
            }
            System.out.println("Move: Up");
        } else if (num == 4) {
            if (currentRow == 9) {
                currentRow = 0;
            } else {
                currentRow ++;
            }
            System.out.println("Move: Down");
        } else {
            System.out.println("Error, invalid input!");
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
