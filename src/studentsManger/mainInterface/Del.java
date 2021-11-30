package studentsManger.mainInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @auther xianyue
 * @date 2020/10/24 -  - 21:13
 **/
public class Del extends Feature {
    private Panel title;
    // 存放学生ID、名字及性别 的Panel
    private Panel stuMsgPl;
    // 存放 登录按钮、重置按钮和取消按钮 的Panel
    private Panel buttPl;

    // textPl
    private Label sIdLb;
    private TextField sIdText;

    // buttPl
    private Button delBt;
    private Button clearBt;
    private Button quitBt;
    private ResponseButton responseButton = new ResponseButton();

    Del(MainInterface f){
        super(f);

        System.out.println("Delete is created");

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
        midPl.add(new Label("Please delete a student"));
        midPl.add(new Panel());

        this.title.add(midPl);
    }

    private void setStuMsgPl(){
        this.stuMsgPl = new Panel(this.fl);

        Panel labelPanel = new Panel(this.gd_1_1);

        this.sIdLb = new Label("stuId:");
        labelPanel.add(sIdLb);

        Panel textPanel = new Panel(this.gd_1_1);
        this.sIdText = new TextField(15);

        this.sIdText.setText("20200001");

        textPanel.add(sIdText);


        this.stuMsgPl.add(labelPanel);
        this.stuMsgPl.add(textPanel);
    }

    private void setButtPl(){
        this.buttPl = new Panel(this.fl);

        this.delBt = new Button("del");
        this.clearBt = new Button("clear");
        this.quitBt = new Button("quit");

        this.delBt.addActionListener(this.responseButton);
        this.clearBt.addActionListener(this.responseButton);
        this.quitBt.addActionListener(this.responseButton);

        this.buttPl.add(delBt);
        this.buttPl.add(clearBt);
        this.buttPl.add(quitBt);
    }



    class ResponseButton implements ActionListener {
        // Button点击反应
        public void actionPerformed(ActionEvent e){
            Object con = e.getSource();
            if (con == Del.this.delBt){
                String id =  Del.this.sIdText.getText();
                String res = Del.this.fatherFrame.stus.delete(id);
                ShowMsg showMsg = new ShowMsg(Del.this, res);
            }
            else if (con == Del.this.clearBt) {
                Del.this.sIdText.setText("");
            }
            else if (con == Del.this.quitBt){
                Del.this.fatherFrame.writeStus(Del.this.fatherFrame.stuFile);
                Del.this.dispose();
            }
        }
    }
}
