package com.yang.atm;
import java.util.*;

public class bank {
    public static void main(String[] args) {
        User[] users=new User[100];
        Scanner sc=new Scanner(System.in);
        boolean flag1=true;
        boolean flag2=true;
        int count=0;
        while(flag2)
        {
            System.out.println("请输入要进行的操作：");
            System.out.println("1.开户");
            System.out.println("2.登录");
            System.out.println("3.退出系统");
            switch (sc.next())
            {
                case "1":
                    User u = ATM.OpenAccount(sc);
                    users[count]=u;
                    count++;
                    break;
                case "2":
                    u = ATM.Signin(sc,users);
                    if(u==null)
                    {

                    }
                    else
                    {
                        System.out.println("登录成功！请选择要进行的操作：");
                       while(flag1)
                       {
                           System.out.println("1.存款");
                           System.out.println("2.取款");
                           System.out.println("3.转账");
                           System.out.println("4.查询");
                           System.out.println("5.注销");
                           switch (sc.next())
                           {
                               case "1":
                                   ATM.Deposit(u,sc);
                                   break;
                               case "2":
                                   ATM.WithdrawMoney(u,sc);
                                   break;
                               case "3":
                                   ATM.Transfer_Accounts(u);
                                   break;
                               case "4":
                                   ATM.Show(u,sc);
                                   break;
                               case "5":
                                   flag1=false;
                                   break;
                               default:
                                   System.out.println("输入指令有误！请重新输入。");

                           }
                       }
                    }
                    break;
                case "3":
                    flag2=false;
                    break;
                default:
                    System.out.println("输入指令错误！请重新输入！");
                    break;

            }
        }
    }
}
