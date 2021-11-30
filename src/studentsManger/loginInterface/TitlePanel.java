package studentsManger.loginInterface;

import java.awt.*;

/**
 * @auther xianyue
 * @date 2020/10/23 - 星期五 - 22:43
 **/
public class TitlePanel extends Panel{
    public TitlePanel(){
        super(new GridLayout(3, 1));
        add(new Label());
        Panel mid_div = new Panel();
        Label name = new Label("Student Management System: login");
        mid_div.add(name);
        add(mid_div);
    }
}
