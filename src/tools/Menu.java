package tools;

import java.util.ArrayList;
import tools.MyTool;

public class Menu extends ArrayList<String>
{
    public Menu()
    {
        super();
    }
    
    public Menu(String[] items)
    {
        super();
        for (String item: items) 
            this.add(item);
    }
    
    public void showMenu()
    {
        System.out.println("Managing Dealers");
        int count = 1;
        for (String item: this)
        {
            System.out.println("    " + count + "-" + item);
            count++;
        }
        System.out.println("Other for quit.");
    }
    
    public int getChoice(String title, int min, int max)
    {
        return MyTool.getAnInteger(title, "Invalid format, try again: ", min, max);
    }
}
