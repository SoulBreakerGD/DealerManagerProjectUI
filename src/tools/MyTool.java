package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.StringTokenizer;

public class MyTool
{
    public static final Scanner sc = new Scanner(System.in);
    
    public static boolean validStr(String str, String regex)
    {
        return str.matches(regex);
    }
    
    public static boolean validPassword(String str, int minLength)
    {
        if(str.length() < minLength)
            return false;
        return str.matches(".*[a-zA-Z]+.*") && // at least 1 character
               str.matches(".*[\\d]+.*") && // at least 1 digit
               str.matches(".*[\\W]+.*"); // at least 1 special character
    }
    
    public static Date parseDate(String dateStr, String dateFormat)
    {
        SimpleDateFormat dF = (SimpleDateFormat)SimpleDateFormat.getInstance();
        dF.applyPattern(dateFormat);
        try 
        {
            long t = dF.parse(dateStr).getTime();
            return new Date(t);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }
    
    public static String dateToStr(Date date, String dateFormat)
    {
        SimpleDateFormat dF = (SimpleDateFormat)SimpleDateFormat.getInstance();
        dF.applyPattern(dateFormat);
        return dF.format(date);
    }
    
    public static boolean parseBool(String boolStr)
    {
        char c = boolStr.trim().toUpperCase().charAt(0);
        return (c == '1' || c == 'Y' || c == 'T');
    }
    
    public static String readNonBlank(String message)
    {
        String input = "";
        do 
        {            
            System.out.print(message + ": ");
            input = sc.nextLine().trim();
        } 
        while(input.isEmpty());
        return input;
    }
    
    public static String readPattern(String message, String pattern)
    {
        String input = "";
        boolean valid;
        do 
        {            
            System.out.print(message + ": ");
            input = sc.nextLine().trim();
            valid = validStr(input, pattern);
        } 
        while(!valid);
        return input;
    }
    
    public static boolean readBool(String message)
    {
        String input;
        System.out.print(message + " [1/0-Y/N-T/F]: ");
        input = sc.nextLine().trim();
        if(input.isEmpty())
            return false;
        char c = Character.toUpperCase(input.charAt(0));
        return (c == '1' || c == 'Y' || c == 'T');
    }
    
    public static List<String> readLinesFromFile(String filename)
    {
        List list = new ArrayList<String>();
        try 
        {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details = bf.readLine())!= null)
            {
                details = details.trim();
                if(!details.isEmpty())
                    list.add(details);
            }
            bf.close();
            fr.close();
        } 
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return list;
    }
    
    public static void writeFile(String filename, List list)
    {
        if(list.size() == 0)
        {
            System.out.println("Empty list");
            return;
        }
        
        try
        {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Object x: list) 
            {
                pw.println(x.toString());
            }
            pw.close();
            fw.close();
        }
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }
    
    public static int getAnInteger(String inputMessage, String errorMessage)
    {
        System.out.print(inputMessage);
        while(true)
        {
            try
            {
                int inputNumber = Integer.parseInt(sc.nextLine());
                return inputNumber;
            }
            catch(Exception ex)
            {
                System.out.print(errorMessage);
            }
        }
    }
    
    public static int getAnInteger(String inputMessage, String errorMessage, int lowerRange, int upperRange)
    {
        if(lowerRange > upperRange)
        {
            int tmp = lowerRange;
            lowerRange = upperRange;
            upperRange = tmp;
        }
        System.out.print(inputMessage);
        while(true)
        {
            try
            {
                int inputNumber = Integer.parseInt(sc.nextLine());
                if(inputNumber < lowerRange || inputNumber > upperRange)
                    throw new Exception();
                return inputNumber;
            }
            catch(Exception ex)
            {
                System.out.print(errorMessage);
            }
        }
    }
    
//    public static void main(String[] args) 
//    {
//        System.out.println("Tests with phone numbers: ");
//        System.out.println(validStr("012345678", "\\d{9}|\\d{11}"));
//        System.out.println(validStr("01234567891", "\\d{9}|\\d{11}"));
//        System.out.println(validStr("12345678", "\\d{9}|\\d{11}"));
//        
//        System.out.println("Tests with passwords: ");
//        System.out.println(validPassword("qwerty", 8));
//        System.out.println(validPassword("qwertyABC", 8));
//        System.out.println(validPassword("12345678", 8));
//        System.out.println(validPassword("qbc123456", 8));
//        System.out.println(validPassword("qbc@123456", 8));
//        
//        System.out.println("Tests with IDs: ");
//        System.out.println(validStr("A0001", "D\\d{3}"));
//        System.out.println(validStr("10001", "D\\d{3}"));
//        System.out.println(validStr("D0001", "D\\d{3}"));
//        System.out.println(validStr("D101", "D\\d{3}"));
//        
//        System.out.println("Tests with dates: ");
//        Date d = parseDate("2022:12:07", "yyyy:MM:dd");
//        System.out.println(d);
//        System.out.println(dateToStr(d, "dd/MM/yyyy"));
//        
//        d = parseDate("12/07/2022", "MM/dd/yyyy");
//        System.out.println(d);
//        d = parseDate("2022/07/12", "yyyy/dd/MM");
//        System.out.println(d);
//        d = parseDate("2000/29/02", "yyyy/dd/MM");
//        System.out.println(d);
//        d = parseDate("2000/30/02", "yyyy/dd/MM");
//        System.out.println(d);
//        d = parseDate("2000/40/16", "yyyy/dd/MM");
//        System.out.println(d);
//        
//        String input = readNonBlank("Input a non-blank string");
//        System.out.println(input);
//        input = readPattern("Phone 9/11 digits", "\\d{9}|\\d{11}");
//        System.out.println(input);
//        input = readPattern("ID- format X00000", "X\\d{5}");
//        System.out.println(input);
//        boolean b = readBool("Input boolean");
//        System.out.println(b);
//    }
}
