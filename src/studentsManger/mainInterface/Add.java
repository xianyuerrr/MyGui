package studentsManger.mainInterface;

import studentsManger.students.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @auther xianyue
 * @date 2020/10/24 - 星期六 - 20:58
 **/
public class Add extends Feature {
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
    private Button addBt;
    private Button clearBt;
    private Button quitBt;
    private ResponseButton responseButton = new ResponseButton();

    Add(MainInterface f){
        super(f);

        System.out.println("Add is created");

        this.setTitle("Add");

        this.setTitlePl();
        this.setButtPl();
        this.setStuMsgPl();

        this.add(this.title);
        this.add(this.stuMsgPl);
        this.add(this.buttPl);

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

        this.addBt = new Button("add");
        this.clearBt = new Button("clear");
        this.quitBt = new Button("quit");

        this.addBt.addActionListener(this.responseButton);
        this.clearBt.addActionListener(this.responseButton);
        this.quitBt.addActionListener(this.responseButton);

        this.buttPl.add(addBt);
        this.buttPl.add(clearBt);
        this.buttPl.add(quitBt);
    }



    class ResponseButton implements ActionListener {
        // Button点击反应
        public void actionPerformed(ActionEvent e){
            Object con = e.getSource();
            if (con == Add.this.addBt){
                String id =  Add.this.sIdText.getText();
                String name =  Add.this.sNameText.getText();
                String sex =  Add.this.sexText.getText();
                Student stu = new Student(id, name, sex);

                String res = Add.this.fatherFrame.stus.add(stu);
                ShowMsg showMsg = new ShowMsg(Add.this, res);
            }
            else if (con == Add.this.clearBt) {
                Add.this.sIdText.setText("");
                Add.this.sNameText.setText("");
                Add.this.sexText.setText("");
            }
            else if (con == Add.this.quitBt){
                Add.this.dispose();
            }
        }
    }
}
