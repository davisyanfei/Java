import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class FrameDemo2 {

    public static void main(String[] args) {
        //创建窗体
        Frame f = new Frame("按钮颜色");
        //大小
        f.setSize(500, 400);
        //居中
        f.setLocationRelativeTo(null);
        //流式布局
        f.setLayout(new FlowLayout());
        //设置按钮
        Button redButton = new Button("红色");
        Button greenButton = new Button("绿色");
        Button blueButton = new Button("蓝色");

        f.add(redButton);
        f.add(greenButton);
        f.add(blueButton);

        //窗口关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });

        //对按钮添加动作事件
//		redButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				f.setBackground(Color.red);
//			}
//		});

        //对按钮的单击事件
//		redButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				f.setBackground(Color.red);
//			}
//		});

        //对按钮添加鼠标进入事件
        redButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                f.setBackground(Color.red);
            }
        });
        //对按钮添加离开事件
        redButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                f.setBackground(Color.white);
            }
        });

        //对按钮添加鼠标进入事件
        greenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                f.setBackground(Color.green);
            }
        });
        //对按钮添加离开事件
        greenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                f.setBackground(Color.white);
            }
        });

        //对按钮添加鼠标进入事件
        blueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                f.setBackground(Color.blue);
            }
        });
        //对按钮添加离开事件
        blueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                f.setBackground(Color.white);
            }
        });
        //窗体可见
        f.setVisible(true);
    }
}
