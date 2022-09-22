package runtime;

import tools.Menu;
import data.Account;
import data.AccountChecker;
import data.Config;
import data.DealerList;
import java.io.File;
import java.util.List;
import tools.MyTool;

public class LogIn 
{
    private Account acc = null;

    public LogIn() 
    {
    }
    
    public LogIn(Account acc) 
    {
        this.acc = acc;
    }
    
    public static Account inputAccount()
    {
        String accName, pwd, role; 
        System.out.println("Please Login to System");
        System.out.print("Your account name [Exxx]: ");
        accName = MyTool.sc.nextLine().trim().toUpperCase();
        System.out.print("Your password: ");
        pwd = MyTool.sc.nextLine().trim();
        System.out.print("Your role [BOSS/ACC-x]: ");
        role = MyTool.sc.nextLine().trim().toUpperCase();
        Account newAcc = new Account(accName, pwd, role);
        return newAcc;
    }

    public Account getAcc() 
    {
        return acc;
    }
    
    public static boolean checkValidity (Account acc, Config config) 
    {
        File f = null;
        String accountsFile = config.getAccountFile();
        List<String> registeredAccounts = MyTool.readLinesFromFile(accountsFile);
        for (String account : registeredAccounts) 
        {
            String[] parts = account.split(",");
            if (acc.getAccName().equalsIgnoreCase(parts[0].trim()) && acc.getPwd().equalsIgnoreCase(parts[1].trim()))
            {
                acc.setRole(parts[2].trim());
                return true;
//                String[] roles = parts[2].trim().split(",");
//                for (int i = 0; i < roles.length; i++) 
//                {
//                    roles[i] = roles[i].trim();
//                }
//                if (roles.length == 1) 
//                {
//                    acc.setRole(roles[0]);
//                    return true;
//                }
//                else
//                {
//                    JFrameUI.checkMultipleRoles(Boolean.TRUE);
//                    JFrameUI.roles = roles;
//                    return true;
//                }
            }
        }
        return false;
    }
    
    public void initApp()
    {
        Account acc = null;
        boolean cont = false;
        boolean valid = false;
        do 
        {            
            AccountChecker accChk = new AccountChecker();
            acc = inputAccount();
            valid = accChk.check(acc);
            if(!valid)
                cont = MyTool.readBool("Invalid account - Try again?");
            if(!valid && !cont)
                System.exit(0);
            if(valid)
                break;
        }
        while (cont);
        LogIn loginObj = new LogIn(acc);
        if(acc.getRole().equalsIgnoreCase("ACC-1"))
        {
            String[] options = {"Add new dealer", "Search a dealer",
                                "Remove a dealer", "Update a dealer",
                                "Print all dealers", "Print continuing dealers",
                                "Print un-continuing dealers", "Write to file", "Exit"};
            Menu menu = new Menu(options);
            DealerList dList = new DealerList(loginObj);
            dList.initWithFile();
            int choice = 0;
            do 
            {        
                menu.showMenu();
                choice = menu.getChoice("Choose [1...9]: ", 1, options.length);
                switch(choice)
                {
                    case 1: dList.addDealer(); break;
                    case 2: dList.searchDealer(); break;
                    case 3: dList.removeDealer(); break;
                    case 4: dList.updateDealer(); break;
                    case 5: dList.printAllDealers(); break;
                    case 6: dList.printContinuingDealers(); break;
                    case 7: dList.printUncontinuingDealers(); break;
                    case 8: dList.writeDealerToFile(); break;
                    default:
                        if(dList.isChanged())
                        {
                            boolean res = MyTool.readBool("Data changed. Write to files?");
                            if(res == true)
                                dList.writeDealerToFile();
                        }
                }
            } 
            while (choice > 0 && choice < options.length);
            System.out.println("Bye.");
        }
    }
}
