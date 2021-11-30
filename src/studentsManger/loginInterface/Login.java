package studentsManger.loginInterface;

import studentsManger.MyMethods;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther xianyue
 * @date 2020/10/22 - 星期四 - 20:52
 **/
public class Login extends Frame{
    private Frame frame;
    private final FlowLayout fl = new FlowLayout();
    private final GridLayout gd_1_1 =  new GridLayout(1, 1);
    private final GridLayout gd_2_1 = new GridLayout(2, 1);

    private Panel midPanel;
    private Panel stuMsg;
    private Panel loginPanelSum;

    private static Map<String, String> Users = new HashMap<String, String>();
    static {
        Users.put("admin", "admin");
    }

    protected Login(){
        super();
        MyMethods.setDeafultWindow(this);
        System.out.println("Login is created");

        setTitle("login by awt");

        this.midPanel = new Panel(new GridLayout(3, 1));

        // 标题
        this.stuMsg = new TitlePanel();

        // 登陆界面主体 panel 组件
        this.loginPanelSum = new LoginPanel(this);

        this.midPanel.add(stuMsg);
        this.midPanel.add(loginPanelSum);

        this.add(midPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }



    public static boolean testUser(String[] sList){
        String user = sList[0], password = sList[1];
        if (findUser(user)){
            if ( password.equals(Users.get(user) ) ){ return true; } else{return false;}
        }
        else{return false;}
    }

    public static boolean findUser(String userName){
        if(Login.Users.containsKey(userName)){ return true; } else{ return false; }
    }

}



