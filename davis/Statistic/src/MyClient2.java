//package top.itwinkle.publib;
import javax.swing.*;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.net.Socket;

public class MyClient2 {
    public static  String hostname="localhost";
    public static Integer portno=8888;

    // 检查字符串是不是为数字，如果是就返回，如果不是返回0
    public static Integer getInteger2(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;


        // 用户输入服务器名称、端口号
/*        hostname = JOptionPane.showInputDialog(null, "请输入服务器名称：\n", "welcome statistic",
                JOptionPane.PLAIN_MESSAGE);
        String strPort = JOptionPane.showInputDialog(null, "请输入端口号：\n", "welcome statistic",
                JOptionPane.PLAIN_MESSAGE);
        if (strPort == null) {  //假如点了取消，就返回
            return;
        }
        portno = getInteger2(strPort);*/

        try {
            //创建Socket对象，指定服务器端的IP与端口
            socket = new Socket(hostname,portno);
            //获取scoket的输入输出流接收和发送信息
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new
                    OutputStreamWriter(socket.getOutputStream()));
            while (JOptionPane.showConfirmDialog(null, "要进行字符转换么", "提示", JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
                //发送信息
                String str = JOptionPane.showInputDialog(null, "请输入字符串：\n", "welcome statistic",
                        JOptionPane.PLAIN_MESSAGE);
                out.write(str + "\n");
                out.flush();
                //如果输入的信息为“end”则终止连接
                if (str.equals("end")) {
                    break;
                }
                //否则，接收并输出服务器端信息
                System.out.println("服务器端说：" + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.exit(0);
        }
    }
}