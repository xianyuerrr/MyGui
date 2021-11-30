package studentsManger.mainInterface;

import java.awt.*;

/**
 * @auther xianyue
 * @date 2020/10/23 - 星期五 - 9:36
 **/
public class MyMenuList extends MenuBar {
    // 菜单栏
    public MyMenuList(){
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 0, 0);
        Menu Menu1 = new Menu("File");
        Menu Menu2 = new Menu("Editor");
        Menu Menu3 = new Menu("Tools");
        Menu Menu4 = new Menu("Help");
        add(Menu1);
        add(Menu2);
        add(Menu3);
        add(Menu4);
    }
}
