import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class WIndowmenu extends JFrame{
    //菜单条
    JMenuBar menubar = new JMenuBar();
    //创建菜单
    JMenu menu = new JMenu("菜单");
    JMenu subMenu = new JMenu("软件项目");
    JMenuItem item,item2;
    public WIndowmenu() {
    }
    @SuppressWarnings("deprecation")
    public void init() {
        setTitle("带菜单的窗口");
        item = new JMenuItem("Java 话题",new ImageIcon("src\\menu\\aa.png"));
        item2 = new JMenuItem("动画话题",new ImageIcon("src\\\\menu\\\\bb.png"));
//		item.setAccelerator(KeyStroke.getKeyStroke('x'));
//		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menu.add(item);
        menu.addSeparator();
        menu.add(item2);
        menu.add(subMenu);
        subMenu.add(new JMenuItem("汽车销售系统",new ImageIcon("src\\\\menu\\\\cc.png")));
        subMenu.add(new JMenuItem("农场信息系统",new ImageIcon("src\\\\menu\\\\dd.png")));
        menubar.add(menu);
        setJMenuBar(menubar);

        setLocationRelativeTo(null);
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        WIndowmenu indowmenu = new WIndowmenu();
        indowmenu.init();
    }
}
