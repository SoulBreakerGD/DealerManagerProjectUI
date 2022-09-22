package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import runtime.LogIn;
import tools.MyTool;

public class DealerList extends ArrayList<Dealer>
{
    LogIn loginObj = null;
    private String dataFile = "";
    boolean changed = false;
    ArrayList<Dealer> list = new ArrayList();
    
    public DealerList(LogIn loginObj)
    {
        this.loginObj = loginObj;
    }
    
    public DealerList getList()
    {
        return this;
    }
    
    private void loadDealerFromFile()
    {
        List lines = new ArrayList<>();
        lines = MyTool.readLinesFromFile(dataFile);
        for (Object line: lines) 
        {
            Dealer newDealer = new Dealer(line.toString().trim());
            this.add(newDealer);
        }
    }
    
    public void initWithFile()
    {
        Config cR = new Config();
        dataFile = cR.getDealerFile();
        loadDealerFromFile();
    }
    
    public int searchDealer(String ID)
    {
        for (int i = 0; i < this.size(); i++)
            if(this.get(i).getID().compareToIgnoreCase(ID) == 0)
                return i;
        return -1;
    }
    
    public void searchDealer()
    {
        Scanner sc = new Scanner(System.in);
        String newID;
        do 
        {         
            System.out.print("Dealer's ID needs searching: ");
            newID = sc.nextLine().toUpperCase();
        } 
        while (!MyTool.validStr(newID, Dealer.ID_FORMAT));
        
        int pos = searchDealer(newID);
        if(pos < 0)
            System.out.println("NOT FOUND!");
        else
            System.out.println("The position is: " + pos);
    }
    
    public void addDealer()
    {
        String ID, name, addr, phone;
        boolean continuing;
        int pos;
        do 
        {            
            ID = MyTool.readPattern("ID of new dealer [Dxxx]", Dealer.ID_FORMAT).toUpperCase();
            pos = searchDealer(ID);
            if(pos >= 0)
                System.out.println("ID is duplicated!");
        } 
        while (pos >= 0);
        
        name = MyTool.readNonBlank("Name of new dealer").toUpperCase();
        addr = MyTool.readNonBlank("Address of new dealer");
        phone = MyTool.readPattern("Phone number of new dealer", Dealer.PHONE_FORMAT);
        continuing = true;
        Dealer newDealer = new Dealer(ID, name, addr, phone, continuing);
        this.add(newDealer);
        System.out.println("New dealer has been added.");
        changed = true;
    }
    
    public void removeDealer()
    {
        String newID;
        do 
        {         
            System.out.print("Dealer's ID needs removing: ");
            newID = MyTool.sc.nextLine().trim().toUpperCase();
        } 
        while (!MyTool.validStr(newID, Dealer.ID_FORMAT));
        
        int pos = searchDealer(newID);
        if(pos < 0)
            System.out.println("Dealer " + newID + " not found!");
        else
        {
            Dealer d = this.get(pos);
            d.setContinuing(false);
            changed = true;
            System.out.println("This dealer has been removed.");
        }
    }
    
    public void updateDealer()
    {
        String newID;
        do 
        {         
            System.out.print("Dealer's ID needs updating [Dxxx]: ");
            newID = MyTool.sc.nextLine().trim().toUpperCase();
        } 
        while (!MyTool.validStr(newID, Dealer.ID_FORMAT));
        
        int pos = searchDealer(newID);
        if(pos < 0)
            System.out.println("Dealer " + newID + " not found!");
        else
        {
            Dealer d = this.get(pos);
            String newName, newAddr, newPhone;
            newName = MyTool.readNonBlank("New name, enter for committing").toUpperCase();
            if(!newName.isEmpty())
            {
                d.setName(newName);
                changed = true;
            }
            
            newAddr = MyTool.readNonBlank("New address, enter for committing");
            if(!newAddr.isEmpty())
            {
                d.setAddr(newAddr);
                changed = true;
            }
            
            newPhone = MyTool.readPattern("New phone, enter for committing", Dealer.PHONE_FORMAT);
            if(!newPhone.isEmpty())
            {
                d.setPhone(newPhone);
                changed = true;
            }
            
            System.out.println("This dealer has been updated.");
        }
    }
    
    public void printAllDealers()
    {
        if(this.isEmpty())
            System.out.println("Empty list!");
        else
            for (Dealer d: this) 
            {
                System.out.println(d.toString());
            }
    }
    
    public void printContinuingDealers()
    {
        boolean check = false;
        for (Dealer d: this) 
            if(d.isContinuing() == true)
            {
                System.out.println(d.toString());
                check = true;
            }
        if(check == false)
            System.out.println("Empty list!");
    }
    
    public void printUncontinuingDealers()
    {
        boolean check = false;
        for (Dealer d: this) 
            if(d.isContinuing() == false)
            {
                System.out.println(d.toString());
                check = true;
            }
        if(check == false)
            System.out.println("Empty list!");
    }
    
    public ArrayList<Dealer> getContinuingDealers()
    {
        list.removeAll(list);
        for (Dealer d: this) 
            if(d.isContinuing() == true)
                list.add(d);
        return list;
    }
    
    public ArrayList<Dealer> getUncontinuingDealers()
    {
        list.removeAll(list);
        for (Dealer d: this) 
            if(d.isContinuing() == false)
                list.add(d);
        return list;
    }
    
    public void writeDealerToFile()
    {
        if(changed)
        {
            MyTool.writeFile(dataFile, this);
            System.out.println("Saved to file");
            changed = false;
        }
    }
    
    public void writeDealerToFile(DealerList dList)
    {
        MyTool.writeFile(dataFile, dList);
    }

    public boolean isChanged() 
    {
        return changed;
    }

    public void setChanged(boolean changed) 
    {
        this.changed = changed;
    }
    
    public Dealer checkExistDealer(String ID)
    {
        for (Dealer d : this) 
        {
            if (d.getID().equals(ID)) return d;
        }
        return null;
    }
    
    public ArrayList<Dealer> getSortedListByID(ArrayList<Dealer> list)
    {
        Comparator<Dealer> orderById = new Comparator<Dealer>() 
        {
            @Override
            public int compare(Dealer d1, Dealer d2)
            {
                return d1.getID().compareTo(d2.getID());
            }
        };
        list.sort(orderById);
        return list;
    }
    
    public ArrayList<Dealer> getSortedListByName(ArrayList<Dealer> list)
    {
        Comparator<Dealer> orderByName = new Comparator<Dealer>() 
        {
            @Override
            public int compare(Dealer d1, Dealer d2) 
            {
                return d1.getName().compareTo(d2.getName());
            }
        };
        list.sort(orderByName);
        return list;
    }
    
    public ArrayList<Dealer> getSortedListByAddress(ArrayList<Dealer> list)
    {
        Comparator<Dealer> orderByAddr = new Comparator<Dealer>() 
        {
            @Override
            public int compare(Dealer d1, Dealer d2) 
            {
                return d1.getAddr().compareTo(d2.getAddr());
            }
        };
        list.sort(orderByAddr);
        return list;
    }
    
    public ArrayList<Dealer> getSortedListByPhone(ArrayList<Dealer> list)
    {
        Comparator<Dealer> orderByPhone = new Comparator<Dealer>() 
        {
            @Override
            public int compare(Dealer d1, Dealer d2) 
            {
                return d1.getPhone().compareTo(d2.getPhone());
            }
        };
        list.sort(orderByPhone);
        for (int i = 0; i < list.size() - 1; i++) 
                for (int j = i + 1; j < list.size(); j++) 
                    if(list.get(i).getPhone().length() > list.get(j).getPhone().length())
                        Collections.swap(list, i, j);
                    else 
                        if(list.get(i).getPhone().length() == list.get(j).getPhone().length())
                            if(list.get(i).getPhone().compareTo(list.get(j).getPhone()) > 0)
                                Collections.swap(list, i, j);
        return list;
    }
}
