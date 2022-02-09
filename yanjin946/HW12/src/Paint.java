import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;

/**
 * HW 12 - Paint
 *
 * <p> Purdue University -- CS 180 -- 2021</p>
 *
 * @author Jin Yan Purdue CS
 *
 * @version Nov 16th, 2021
 */

// Jcomponent 是java的图形化组件，可以透明的类似jpanel的组件容器，属于java.swing类库中
//    在实例化的时候首先运行constructor然后运行 paintComponent （swing类的组件创建后自动运行）
    //在本程序中， 因为paint对象 引用了 Runnable接口，那么运行顺序为， construtor--》run--》paintCompont



public class Paint extends JComponent implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());  //swing类事件分发线程去运行一个runnable线程
        System.out.println("after invoke command,Main Thread running... "+runoder++);
    }

    static int runoder; //程序执行顺序计数器
    Image image;          //swing的图形类
    Graphics2D graphics2D;  //2d 图形类
    int curX;
    int curY;
    int oldX;
    int oldY;
    JButton clrButton;  // button类
    JButton fillButton;
    JButton eraseButton;
    JButton randomButton;
    JButton hexButton;
    JButton rgbButton;
    JTextField hexText;  //JextField 输入框类
    JTextField rText;
    JTextField gText;
    JTextField bText;
    Paint paint;  // 一个指针，在new的时候会生成一本类的对象，并赋值

    @Override
    public void run() {
        System.out.println("run class first step..."+runoder++);
        JFrame frame = new JFrame(); // Jframe是一个窗口类，框架
        frame.setTitle("Paint");

        Container content = frame.getContentPane();  //获取Jframe窗口的容器对象，jfram本身不能放component
        content.setLayout(new BorderLayout());  //把容器对象的窗口布局设置为BorderLayout 上下左右中
        paint = new Paint(); // 实例化一个Paint对象 Jcompenent
        content.add(paint, BorderLayout.CENTER); //把这个Jcompent透明panel放在中间

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);  //frame置于屏幕中央
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //设置frame关闭点那个x以后的操作
        // DISPOSE_ON_CLOSE（在 WindowConstants 中定义）：调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。


        clrButton = new JButton("Clear"); //创建button，，，
        fillButton = new JButton("Fill");
        eraseButton = new JButton("Erase");
        randomButton = new JButton("Random");
        hexButton = new JButton("Hex");
        rgbButton = new JButton("RGB");
        hexText = new JTextField("#", 10);
        rText = new JTextField(5);
        gText = new JTextField(5);
        bText = new JTextField(5);

        JPanel panelTop = new JPanel();  //创建一个panel
        panelTop.add(clrButton);    //放button咋panel上，理解容器的含义
        clrButton.addActionListener(actionListener); //button,加入消息处理函数
        panelTop.add(fillButton);
        fillButton.addActionListener(actionListener);
        panelTop.add(eraseButton);
        eraseButton.addActionListener(actionListener);
        panelTop.add(randomButton);
        randomButton.addActionListener(actionListener);
        content.add(panelTop, BorderLayout.NORTH);  //paneltop放在上边。contend.add 激发paint事件
 //       System.out.println("content.add firest time..runorder= "+runoder++);


        JPanel panelBottom = new JPanel(); //创建 panelBottom
        panelBottom.add(hexButton);
        hexButton.addActionListener(actionListener);
        panelBottom.add(rgbButton);
        rgbButton.addActionListener(actionListener);
        panelBottom.add(hexText);
        panelBottom.add(rText);
        panelBottom.add(gText);
        panelBottom.add(bText);
        content.add(panelBottom, BorderLayout.SOUTH); //panel放在下边

        frame.setVisible(true);
        repaint();
        System.out.println("run methond edd..runorder= "+runoder++);


/*        curX=10;
        System.out.println(this.curX);
        System.out.println(paint.curX);*/

    }

    //消息处理对象，统一处理每个button的消息事件
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {  //ActonEvent e 接收jvm发来的消息
            if (e.getSource() == clrButton) {  //如果是clrbutton的消息，，对于button类默认click。
                paint.clrBackground();
                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");
                paint.myPaint();
            }
            if (e.getSource() == fillButton) {
                paint.fillBackground();
                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");
            }
            if (e.getSource() == eraseButton) {
                paint.eraseBackground();
            }
            if (e.getSource() == randomButton) {
                Random random = new Random();
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                Color rgbColor = new Color(r, g, b);
                paint.setPenColor(rgbColor);
                hexText.setText(String.format("#%02x%02x%02x", r, g, b));
                rText.setText(Integer.toString(r));
                gText.setText(Integer.toString(g));
                bText.setText(Integer.toString(b));
            }
            if (e.getSource() == hexButton) {
                try {
                    Color color = Color.decode(hexText.getText());
                    paint.setPenColor(color);
                    rText.setText(Integer.toString(color.getRed()));
                    gText.setText(Integer.toString(color.getGreen()));
                    bText.setText(Integer.toString(color.getBlue()));

                } catch (NumberFormatException i) {
                    System.out.println(i);
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (e.getSource() == rgbButton) {

                try {
                    if(Objects.equals(rText.getText(), "")) {
                        rText.setText("0");
                    }
                    if(Objects.equals(gText.getText(), "")) {
                        gText.setText("0");
                    }
                    if(Objects.equals(bText.getText(), "")) {
                        bText.setText("0");
                    }
                    int r = Integer.parseInt(rText.getText()) ;
                    int g = Integer.parseInt(gText.getText()) ;
                    int b = Integer.parseInt(bText.getText()) ;
                    Color rgbColor = new Color(r, g, b);
                    paint.setPenColor(rgbColor);
                    hexText.setText(String.format("#%02x%02x%02x", r, g, b));

                } catch (Exception i) {
                    System.out.println(i);
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    };

    // graphi2d，设置成白色，清除北京
    public void clrBackground() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void setPenColor(Color color) {
        graphics2D.setPaint(color);
    }

    public void eraseBackground() {
        graphics2D.setPaint(graphics2D.getBackground());
    }

    public void fillBackground() {
        graphics2D.setBackground(graphics2D.getColor());
        graphics2D.setPaint(graphics2D.getBackground());
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    //在创建 paint的时候自动运行
    protected void paintComponent(Graphics g) {

        if (image == null) {
            image = createImage(getSize().width, getSize().height); //jgetsize是paint的大小
            graphics2D = (Graphics2D) image.getGraphics(); //把image对象.getGraphis 转换成g2d对象并赋值
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();  //repaint会激发paintcomponent方法，想想为啥不会无限调用？
            System.out.println("paintComponent create image Runoder="+runoder++);
        }
        g.drawImage(image, 0, 0, null);
        System.out.println("paintComponent  Runoder="+runoder++);
/*        System.out.println("paintComponent printing obj "+this);
        System.out.println("paintComponent printing image "+image);*/
    }

    public class MouseAdp extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            oldX = e.getX();
            oldY = e.getY();
        }
    }

    //Paint的构建函数 把鼠标动作记录下来
    public Paint() {
/*        MouseAdp mouseAdp=new MouseAdp();
        addMouseListener(mouseAdp);*/

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                curX = e.getX();
                curY = e.getY();

                graphics2D.drawLine(oldX, oldY, curX, curY);

                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
        System.out.println("construction runoder is =" +runoder++);
    }



    public void myPaint() {
/*        MouseAdp mouseAdp=new MouseAdp();
        addMouseListener(mouseAdp);*/

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("x is"+ e.getX()+" and Y is "+e.getY());;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                curX = e.getX();
                curY = e.getY();

                graphics2D.drawLine(oldX, oldY, curX, curY);

                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
        System.out.println("construction runoder is =" +runoder++);
    }

}