import java.io.File;

public class Counter2 {

    public static void main(String[] args) {
//取得目标目录
        File file = new File("D:/github");
//获取目录下子文件及子文件夹

        readfile(file);

    }

    public static void readfile(File file) {
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if (files == null) {// 如果目录为空，直接退出
            return;
        }
        for(File f:files) {
//如果是文件，直接输出名字
            if(f.isFile()) {
                System.out.println(f.getName());
            }
//如果是文件夹，递归调用
            else if(f.isDirectory()) {
                readfile(f);
            }
        }
    }
}