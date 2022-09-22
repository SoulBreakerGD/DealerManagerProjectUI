package runtime;

import tools.Menu;

public class Program 
{
    public static void main(String[] args) 
    {
        String[] options = {"Run app with console", "Run app with UI"};
        Menu menu = new Menu(options);
        menu.showMenu();
        int choice = menu.getChoice("Choose [1 - 2]: ", 1, 2);
        if (choice == 1)
        {
            LogIn login = new LogIn();
            login.initApp();
        }
        else
        {
            JFrameUI jframe = new JFrameUI();
            jframe.initUI();
        }
    }
}
