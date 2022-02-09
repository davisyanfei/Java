import java.io.File;
import java.net.URL;

public class MainTest_FindAllSubClass {
    public static void main(String[] args) {

        Class<?> clazz = MainTest_FindAllSubClass.class;
        // 定位到当前的包路径
        // URL url = Toy.class.getResource("");

        // 定位到bin目录
        URL url = clazz.getResource("/");
        // URL url = clazz.getResource("/D:/Java/jdk1.8.0_181/javafx-src.zip/");
        System.out.println(url);

        String fileName = url.getFile();
        System.out.println(fileName);

        String pathName = fileName.replaceFirst("/", "");
        System.out.println(pathName);

        File rootFile = new File(pathName);
        System.out.println(rootFile.getPath());

        setSubList(rootFile, rootFile.getPath() + "\\", clazz);
    }

    /**
     * 遍历bin目录下所有文件
     * 若是文件夹，则递归将文件夹内文件添加到文件数组
     * 若是文件，则将文件加载并强制类型转换为要查找子类的父类，转换无异常，说明加载类是父类的子类
     * (当遍历到类自身时，此处认为也属于子类，当然这是我的一厢情愿，我肯定不告诉你--〉我嫌麻烦。。
     *  不过我还是加上了判断--〉自我要求比较高。。
     * )
     * */
    public static <T> void setSubList(File rootFile, String parentDirectory,
                                      Class<T> parentClass) {
        if (rootFile.isDirectory()) {
            File[] files = rootFile.listFiles();
            for (File file : files) {
                setSubList(file, parentDirectory, parentClass);
            }
        } else {
            String className = null;
            try {
                if (rootFile.getPath().indexOf(".class") != -1) {
                    className = rootFile.getPath().replace(parentDirectory, "")
                            .replace(".class", "").replace("\\", ".");
                    Class<?> classObject = Class.forName(className);
                    classObject.asSubclass(parentClass);

                    // 要么是子类，要么是类本身
                    if (! className.equals(parentClass.getCanonicalName())){
                        System.out.println(className + " extends " + parentClass);
                    }else{
                        System.out.println(className + " is " + parentClass);
                    }
                }
            } catch (ClassNotFoundException e) {
                System.err.println("can not find " + className);
            } catch (ClassCastException e) {
                System.err.println(className + " do not extends " + parentClass);
            }
        }
    }
}

// 测试
class Sub1 extends MainTest_FindAllSubClass {
}

//测试
class Sub2 extends MainTest_FindAllSubClass {
}