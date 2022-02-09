//package top.itwinkle.publib;
// Yanjin pkg，  services:  jin.itwinkle.top 6100--6400

import javax.swing.*;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.net.ServerSocket;
        import java.net.Socket;

public class MyServer2 {
    public static  String hostname="localhost";
    public static Integer portno=8888;

    public static String statisChar(String args1) {
        String str1 = "",str2="",strReturn="";
        Integer len=0,  //串长度
                wordcnt=0, //word数量
                puncnt=0, //标点符号数量
                charcnt=0, //字符数量
                otherCnt=0 ; //码值大于127的unicode的字符数量

        /* 按照asciii表取出把字符串中所有的字符进行统计，包括标点符号和空格 存入数组，数组的下标就是ascii值 */
        int[] count = new int[128]; //按ascii表取出所有字符重复出现的次数
        len=args1.length();
        for(int i=0; i<len; i++){
            char tmp = args1.charAt(i); //依次取出每个字母
            int index = tmp ; //利用ascii码表，最小结果是0.
            if (index<126) {count[index] = count[index] + 1;}
            else otherCnt=otherCnt+1;
        }
        //统计 number of words  不是连续标点符号，或者不是连续空格，就认为是一个词。
        //空格 32 标点符号 33-47  58-64  91-96 123-126  数字： 48-57 字符65-90 97-122
        //循环打印每个字母出现次数
        wordcnt = count[32];

        for(int j=33; j<48; j++){ puncnt=puncnt+count[j];}
        for(int j=58; j<65; j++){ puncnt=puncnt+count[j];}
        for(int j=91; j<97; j++){ puncnt=puncnt+count[j];}
        for(int j=123; j<127; j++){ puncnt=puncnt+count[j];}
        //char count
        for(int j=65; j<91; j++){ charcnt=charcnt+count[j];}
        for(int j=97; j<123; j++){ charcnt=charcnt+count[j];}
        //frequeny of digital
        for(int j=48; j<58; j++){
            if(count[j]!=0)
                str1 = str1+ (char)(j)+"-"+count[j]+",";
        }
        //frequency of char
        for(int j=65; j<91; j++){
            if(count[j]!=0)
                str2 = str2+ (char)(j)+"-"+count[j]+",";
        }
        for(int j=97; j<123; j++){
            if(count[j]!=0)
                str2 = str2+ (char)(j)+"-"+count[j]+",";
        }
        strReturn = "Length is "+len+";"
                +"Number of words is "+wordcnt+";"
                +"Number of punctution is "+puncnt+";"
                +"Character count is "+charcnt+";"
                +"Frequency of digits is "+str1+";"
                +"Frequency of charactor is "+str2+";"
                +"Number of unicodeOthercountry is "+otherCnt
                ;
        return  strReturn;
    }

    public static void main(String[] args){
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        BufferedReader br = null;



        try {
            //创建服务器端套接字：指定监听端口
            ServerSocket server = new ServerSocket(portno);
            //监听客户端的连接
            socket = server.accept();
            //获取socket的输入输出流接收和发送信息
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new
                    OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                //接收客户端发送的信息
                String str = in.readLine();
                System.out.println("客户端说：" + str);
                String str2 = "";
                //如果客户端发送的是“end”则终止连接
                if (str.equals("end")){
                    break;
                }
                //否则，发送反馈信息
                str2 = statisChar(str); // 读到\n为止，因此一定要输入换行符！
                out.write(str2 + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}