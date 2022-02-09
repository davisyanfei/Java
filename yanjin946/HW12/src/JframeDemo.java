import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class JframeDemo {

    public static void main(String[] args) {

        // Jframe 类创建窗口
        JFrame jf = new JFrame("文本框");

        //大小
        jf.setSize(400, 400);

        //居中
        jf.setLocationRelativeTo(null);

        //流式布局
        jf.setLayout(new FlowLayout());
        Label label = new Label("只能输入数字，不信你试试！");
        //创建文本框
        TextField tf = new TextField(30);


        //加入窗体
        jf.add(label);
        jf.add(tf);


        //窗口可关闭
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //可见
        jf.setVisible(true);
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                char ch = e.getKeyChar();
                if(!(ch>='0'&&ch<='9')) {
                    e.consume();
                }
            }
        });
    }
}
