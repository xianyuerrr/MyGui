package studentsManger.mainInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @auther xianyue
 * @date 2020/10/24 - 星期六 - 21:14
 **/
public class Find extends Feature{
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

    Find(MainInterface f){
        super(f);

        System.out.println("Find is created");

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
        midPl.add(new Label("Please find a student"));
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

        this.delBt = new Button("find");
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
            if (con == Find.this.delBt){
                String id =  Find.this.sIdText.getText();
                String res = Find.this.fatherFrame.stus.find(id);
                ShowMsg showMsg = new ShowMsg(Find.this, res);
            }
            else if (con == Find.this.clearBt) {
                Find.this.sIdText.setText("");
            }
            else if (con == Find.this.quitBt){
                Find.this.fatherFrame.writeStus(Find.this.fatherFrame.stuFile);
                Find.this.dispose();
            }
        }
    }
}
