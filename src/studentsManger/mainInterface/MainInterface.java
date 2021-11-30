package studentsManger.mainInterface;

import studentsManger.MyMethods;
import studentsManger.students.StudentsFile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @auther xianyue
 * @date 2020/10/23 - 星期六 - 8:33
 **/
public class MainInterface extends Frame {
    private final FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 0, 0);
    private final GridLayout gd_1_3 = new GridLayout(1, 3);
    private final GridLayout gd_7_1 = new GridLayout(7, 1);

    // 可进行的操作
    private Panel featurePl = new Panel(fl);

    // 操作的按钮
    private Button addButton;
    private Button delButton;
    private Button changeButton;
    private Button findButton;
    private Button showButton;

    private Frame addFrame;
    private Frame delFrame;
    private Frame changeFrame;
    private Frame findFrame;
    private Dialog showDialog;


    StudentsFile stus = new StudentsFile();


    public MainInterface(){
        super();

        this.stus = new StudentsFile();

        MyMethods.setDeafultWindow(this);

        // 设置标题
        setTitle("Student Management System");
        // 设置菜单栏
        setMenuBar(new MyMenuList());

        this.setFeaturePl();

        this.add(this.featurePl);

        this.setVisible(true);
    }

    private void setFeaturePl(){
        Panel featurePl = this.featurePl;
        featurePl.setLayout(gd_1_3);
        featurePl.add(new Panel());

        Panel havePanel = new Panel(gd_7_1);

        havePanel.add(new Panel());
        this.addButton = new Button("add");
        this.delButton = new Button("del");
        this.changeButton = new Button("change");
        this.findButton = new Button("find");
        this.showButton = new Button("show");

        ResponseButton rb = new ResponseButton();

        this.addButton.addActionListener(rb);
        this.delButton.addActionListener(rb);
        this.changeButton.addActionListener(rb);
        this.findButton.addActionListener(rb);
        this.showButton.addActionListener(rb);

        havePanel.add(this.addButton);
        havePanel.add(this.delButton);
        havePanel.add(this.changeButton);
        havePanel.add(this.findButton);
        havePanel.add(this.showButton);

        featurePl.add(havePanel);
        featurePl.add(new Panel());
    }


    class ResponseButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Object con = e.getSource();
            if (con == MainInterface.this.addButton){
                MainInterface.this.addFrame = new Add(MainInterface.this);
            }
            else if (con == MainInterface.this.delButton){
                MainInterface.this.delFrame = new Del(MainInterface.this);
            }
            else if (con == MainInterface.this.changeButton){
                MainInterface.this.changeFrame = new Change(MainInterface.this);
            }
            else if (con == MainInterface.this.findButton){
                MainInterface.this.findFrame = new Find(MainInterface.this);
            }
            else if (con == MainInterface.this.showButton){
                MainInterface.this.showDialog = new ShowStu(MainInterface.this);
            }
        }
    }


}
