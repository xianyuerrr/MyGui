package studentsManger.loginInterface;

import studentsManger.mainInterface.MainInterface;
import studentsManger.MyMethods;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @auther xianyue
 * @date 2020/10/23 - 星期五 - 21:25
 **/
public class Prompt extends Dialog {
    private final FlowLayout fl = new FlowLayout();
    private final GridLayout gd_4_1 = new GridLayout(4,1);
    private Button confirm;
    private Label message;
    private Panel row1 = new Panel(fl);
    private Panel row2 = new Panel(fl);
    private Frame fatherFrame;
    private boolean loginStatus;

    Prompt(Frame f, boolean match){
        super(f);
        this.fatherFrame = f;
        this.loginStatus = match;

        addWindowListener(new ResponseColck());

        System.out.println("Prompt is created");

        this.setTitle("Prompt");
        this.setSize(200, 150);
        MyMethods.conCenter(this);
        this.setVisible(true);

        this.setLayout(gd_4_1);


        if(this.loginStatus){ this.successMatch(); } else{ this.failMatch(); }

        this.add(new Panel());
        this.add(row1);
        this.add(row2);
        this.add(new Panel());

        this.setVisible(true);
    }


    private void successMatch(){
        this.message = new Label("Successful landing!!!");
        this.confirm = new Button("confirm");
        this.confirm.addActionListener(new ResponseSuccessLogin());
        this.row1.add(this.message);
        this.row2.add(this.confirm);
    }

    private void failMatch(){
        this.message = new Label("Incorrect username or password");
        this.confirm = new Button("confirm");
        this.confirm.addActionListener(new ResponseFail());
        this.row1.add(this.message);
        this.row2.add(this.confirm);
    }


    class ResponseSuccessLogin implements ActionListener {
        public void actionPerformed(ActionEvent e){
            // 关闭当前登录窗口
            Prompt.this.fatherFrame.dispose();

            // 打开程序主界面窗口
            MainInterface mainInterface = new MainInterface();
        }
    }

    class ResponseFail implements ActionListener{
        public void  actionPerformed(ActionEvent e){
            // 关闭当前Dialog窗口, 关闭全部窗口不合理
            Prompt.this.dispose();
        }
    }

    class ResponseColck extends WindowAdapter {
        // 叉号关闭窗口
        public void windowClosing(WindowEvent e){
            // 关闭当前Dialog窗口, 关闭全部窗口不合理
            Prompt.this.dispose();
        }
    }

}
