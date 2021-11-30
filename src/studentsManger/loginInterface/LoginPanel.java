package studentsManger.loginInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @auther xianyue
 * @date 2020/10/23 - 星期五 - 22:47
 **/
public class LoginPanel extends Panel {
    // Layout
    static GridLayout gd_2_1 = new GridLayout(2,1);
    static FlowLayout fl = new FlowLayout();

    // 用户名 和 密码，及其 文本框
    private Panel row_1;
    // 登录按钮 和 取消按钮
    private Panel row_2;

    // row1
    private Label acBt;
    private Label pwBt;
    private TextField acText;
    private TextField pwText;

    // row2
    private Button loginBt;
    private Button quitBt;
    private ResponseButton responseButton = new ResponseButton();
    private Frame fatherFrame;

    LoginPanel(Frame fatherFrame){
        super();
        System.out.println("LoginPanel is created");

        this.fatherFrame = fatherFrame;

        setLayout(gd_2_1);

        this.setRow1();
        this.setRow2();

        add(this.row_1);
        add(this.row_2);
    }

    private void setRow1(){
        this.row_1 = new Panel(LoginPanel.fl);
        // 用户名 和 密码，及其 文本框
        Panel labelPanel = new Panel(gd_2_1);
        this.acBt = new Label("User ID:");
        this.pwBt = new Label("Password:");

        labelPanel.add(acBt);
        labelPanel.add(pwBt);

        Panel TextPanel = new Panel(gd_2_1);
        this.acText = new TextField(15);
        this.pwText = new TextField(15);
        this.pwText.setEchoChar('*');

        this.acText.setText("admin");
        this.pwText.setText("admin");

        TextPanel.add(acText);
        TextPanel.add(pwText);

        row_1.add(labelPanel);
        row_1.add(TextPanel);
    }

    private void setRow2(){
        this.row_2 = new Panel(LoginPanel.fl);
        // 登录按钮 和 取消按钮
        this.loginBt = new Button("login");
        this.quitBt = new Button("quit");

        this.loginBt.addActionListener(this.responseButton);
        this.quitBt.addActionListener(this.responseButton);

        this.row_2.add(loginBt);
        this.row_2.add(quitBt);
    }

    class ResponseButton implements ActionListener {
        // Button点击反应
        public void actionPerformed(ActionEvent e){
            Object con = e.getSource();
            if (con == LoginPanel.this.loginBt){
                String user = LoginPanel.this.acText.getText(), password = LoginPanel.this.pwText.getText();
                Prompt prompt = new Prompt(LoginPanel.this.fatherFrame, Login.testUser(new String[] {user, password}));
            }
            else if(con == LoginPanel.this.quitBt){
                System.exit('0');
            }
        }
    }
}
