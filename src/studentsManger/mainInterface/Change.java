package studentsManger.mainInterface;

import studentsManger.students.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @auther xianyue
 * @date 2020/10/24 - 星期六 - 21:14
 **/
public class Change extends Feature{
    private Panel title;
    // 存放学生ID、名字及性别 的Panel
    private Panel stuMsgPl;
    // 存放 登录按钮、重置按钮和取消按钮 的Panel
    private Panel buttPl;

    // textPl
    private Label sIdLb;
    private Label sNameLb;
    private Label sexLb;
    private TextField sIdText;
    private TextField sNameText;
    private TextField sexText;

    // buttPl
    private Button changeBt;
    private Button clearBt;
    private Button quitBt;
    private ResponseButton responseButton = new ResponseButton();

    Change(MainInterface f){
        super(f);

        System.out.println("Change is created");

        this.setTitle("Change");

        this.setTitlePl();
        this.add(this.title);

        this.setStuMsgPl();
        this.add(stuMsgPl);

        this.setButtPl();
        this.add(buttPl);

        this.setVisible(true);
    }

    private void setTitlePl(){
        this.title = new Panel(fl);
        Panel midPl = new Panel(gd_3_1);
        midPl.add(new Panel());
        midPl.add(new Label("Please add a student"));
        midPl.add(new Panel());

        this.title.add(midPl);
    }

    private void setStuMsgPl(){
        this.stuMsgPl = new Panel(this.fl);

        Panel labelPanel = new Panel(this.gd_3_1);

        this.sIdLb = new Label("stuId:");
        this.sNameLb = new Label("stuName:");
        this.sexLb = new Label("stuSex:");
        labelPanel.add(sIdLb);
        labelPanel.add(sNameLb);
        labelPanel.add(sexLb);

        Panel textPanel = new Panel(this.gd_3_1);
        this.sIdText = new TextField(15);
        this.sNameText = new TextField(15);
        this.sexText = new TextField(15);

        this.sIdText.setText("20200001");
        this.sNameText.setText("Lisa");
        this.sexText.setText("woman");

        textPanel.add(sIdText);
        textPanel.add(sNameText);
        textPanel.add(sexText);

        this.stuMsgPl.add(labelPanel);
        this.stuMsgPl.add(textPanel);
    }

    private void setButtPl(){
        this.buttPl = new Panel(this.fl);

        this.changeBt = new Button("change");
        this.clearBt = new Button("clear");
        this.quitBt = new Button("quit");

        this.changeBt.addActionListener(this.responseButton);
        this.clearBt.addActionListener(this.responseButton);
        this.quitBt.addActionListener(this.responseButton);

        this.buttPl.add(changeBt);
        this.buttPl.add(clearBt);
        this.buttPl.add(quitBt);
    }



    class ResponseButton implements ActionListener {
        // Button点击反应
        public void actionPerformed(ActionEvent e){
            Object con = e.getSource();
            if (con == Change.this.changeBt){
                String id =  Change.this.sIdText.getText();
                String name =  Change.this.sNameText.getText();
                String sex =  Change.this.sexText.getText();
                Student stu = new Student(id, name, sex);

                String res = Change.this.fatherFrame.stus.change(stu);
                ShowMsg showMsg = new ShowMsg(Change.this, res);
            }
            else if (con == Change.this.clearBt) {
                Change.this.sIdText.setText("");
                Change.this.sNameText.setText("");
                Change.this.sexText.setText("");
            }
            else if (con == Change.this.quitBt){
                Change.this.fatherFrame.writeStus(Change.this.fatherFrame.stuFile);
                Change.this.dispose();
            }
        }
    }
}
