package data;

public class Account 
{
    private String accName; 
    private String pwd;
    private String role;

    public Account(String accName, String pwd, String role)
    {
        this.accName = accName;
        this.pwd = pwd;
        this.role = role;
    }
    
    public Account(String accName, String pwd)
    {
        this.accName = accName;
        this.pwd = pwd;
    }

    public String getAccName()
    {
        return accName;
    }

    public String getPwd() 
    {
        return pwd;
    }

    public String getRole() 
    {
        return role;
    }

    public void setAccName(String accName) 
    {
        this.accName = accName;
    }

    public void setPwd(String pwd) 
    {
        this.pwd = pwd;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }
    
    
}
