package com.yang.atm;

import java.util.*;

public class User {
    private String BankId;
    private String PassWord;
    private double balance;
    private String Name;

    public User() {
    }

    public User(String bankId, String passWord, double balance, String name) {
        BankId = bankId;
        PassWord = passWord;
        this.balance = balance;
        Name = name;
    }

    public String getBankId() {
        return BankId;
    }

    public void setBankId(String bankId) {
        BankId = bankId;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean ZhuangZhang(double gold)       //转账
    {
        if(gold>this.balance)
            return false;
        else
        {
            this.balance-=gold;
            return true;
        }
    }
    public boolean deposit(double gold)
    {
        this.balance+=gold;
        return true;
    }
}
class YanZhengMa
{
    private static String yzm="ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxy0123456789";
    public static String YZM()
    {
        String m="";
        for(int i =0;i<6;i++)
        {
            Random r=new Random();
            int num=r.nextInt(yzm.length());
            m+=yzm.charAt(num);

        }
        return m;
    }
}
