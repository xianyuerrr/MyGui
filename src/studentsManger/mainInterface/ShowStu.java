package studentsManger.mainInterface;

import studentsManger.MyMethods;
import studentsManger.students.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Map;

/**
 * @auther xianyue
 * @date 2020/11/14 - 星期六 - 15:32
 **/
public class ShowStu extends Dialog {
    private final FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 0, 0);
    private final GridLayout gd_1_3 = new GridLayout(1, 3);
    private MainInterface fatherFrame;

    private List stuList;
    private Button updateBt;

    public ShowStu(MainInterface owner) {
        super(owner);
        this.fatherFrame = owner;

        this.setTitle("show");
        this.setLayout(fl);
        this.setSize(400, 300);
        MyMethods.conCenter(this);
        this.addWindowListener(new ResponseColck());

        this.stuList = new List(16);
        this.updateListPl();

        this.updateBt = new Button("update");
        this.updateBt.addActionListener(new ResponseButton());

        this.add(stuList);
//        this.add(updateBt);
        this.setVisible(true);
    }


    public void updateListPl(){
        this.stuList.clear();
        Map<String, Student> map = this.fatherFrame.stus.getStudents();
        Iterator<Map.Entry<String, Student>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Student> entry = entries.next();
            this.stuList.add(String.valueOf(entry.getValue()));
        }
    }


    class ResponseButton implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Object con = e.getSource();
            if (con == ShowStu.this.updateBt){
                ShowStu.this.updateListPl();
            }
        }
    }


    class ResponseColck extends WindowAdapter {
        public void windowClosing(WindowEvent e){
            ShowStu.this.dispose();
        }
    }
}
