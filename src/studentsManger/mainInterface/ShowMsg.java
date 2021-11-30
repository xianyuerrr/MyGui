package studentsManger.mainInterface;

import studentsManger.MyMethods;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @auther xianyue
 * @date 2020/11/14 - 星期六 - 11:06
 **/
public class ShowMsg extends Dialog {
    private final FlowLayout fl = new FlowLayout();
    private final GridLayout gd_4_1 = new GridLayout(4,1);
    private Button confirm;
    private Label message;
    private Panel row1 = new Panel(fl);
    private Panel row2 = new Panel(fl);
    private Frame fatherFrame;

    ShowMsg(Frame owner, String msg) {
        super(owner);
        this.fatherFrame = owner;

        this.setTitle("ShowMsg");
        this.setSize(600, 150);
        this.setLayout(gd_4_1);
        MyMethods.conCenter(this);
        this.addWindowListener(new ResponseColck());

        this.message = new Label(msg);
        this.confirm = new Button("confirm");
        this.confirm.addActionListener(new ResponseConfirm());
        this.row1.add(this.message);
        this.row2.add(this.confirm);

        this.add(new Panel());
        this.add(row1);
        this.add(row2);
        this.add(new Panel());

        this.setVisible(true);
    }

    class ResponseConfirm implements ActionListener {
        public void actionPerformed(ActionEvent e){
            ShowMsg.this.dispose();
        }
    }


    class ResponseColck extends WindowAdapter {
        // 叉号关闭窗口
        public void windowClosing(WindowEvent e){
            // 关闭当前Dialog窗口, 关闭全部窗口不合理
            ShowMsg.this.dispose();
        }
    }

}
