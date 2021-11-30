package studentsManger;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @auther xianyue
 * @date 2020/10/23 - 星期五 - 21:27
 **/
public class MyMethods {
    public static final ResponseColck responseColck = new ResponseColck();

    public static void conCenter(Container con){
        // 使容器主界面居中
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        con.setLocation(screenWidth/2 - con.getWidth()/2, screenHeight/2 - con.getHeight()/2);
    }

    public static void setDeafultWindow(Window window){
        window.setSize(600, 334);
        MyMethods.conCenter(window);
        // 叉号关闭程序
        window.addWindowListener(MyMethods.responseColck);
        window.setVisible(true);
    }


    static class ResponseColck extends WindowAdapter {
        // 叉号关闭窗口
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }

}
