package studentsManger.mainInterface;

import studentsManger.MyMethods;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @auther xianyue
 * @date 2020/10/24 - 星期六 - 21:04
 **/
public class Feature extends Frame {
    // 子类也拥有此属性
    protected MainInterface fatherFrame;
    protected GridLayout gd_3_1 = new GridLayout(3,1);
    protected GridLayout gd_1_1 = new GridLayout(1,1);
    protected FlowLayout fl = new FlowLayout();
    Feature(MainInterface frame){
        super();
        this.fatherFrame = frame;

        this.setLayout(new GridLayout(3,1));
        this.setSize(400, 300);
        MyMethods.conCenter(this);
        this.addWindowListener(new ResponseColck());


        this.setVisible(true);
    }

    class ResponseColck extends WindowAdapter {
        // 叉号关闭窗口
        public void windowClosing(WindowEvent e){
            Feature.this.dispose();
        }
    }
}
