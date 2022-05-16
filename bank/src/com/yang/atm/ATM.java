package com.yang.atm;

import java.util.Scanner;

public class ATM
{
    /*
    进行进行银行开户操作
     */
    //增加一个个人账户并初始化信息。并返回该账户
    public static User OpenAccount(Scanner sc)
    {
        User u=new User();
        System.out.println("请输入您的姓名：");
        u.setName(sc.next());
        System.out.println("请输入您的账户密码：");
        u.setPassWord(sc.next());
        System.out.println("请输入您的银行账户");
        u.setBankId(sc.next());
        System.out.println("开户成功！您的余额为："+u.getBalance());
        return u;
    }
/*登录*/
    //输入id和密码进行判断，同时通过验证码辅助验证，如果验证码正确再进行id和密码判断。
    //登录成功返回此时的账户
    public static User Signin(Scanner sc,User[] users)
    {
        System.out.println("请输入银行ID：");
        String id=sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();
        String yzm="";
        while(true)
        {
            yzm=YanZhengMa.YZM();
            System.out.println(yzm+"\n请输入验证码：");
            String comdom=sc.next();
            if (yzm.equals(comdom))
            {
                for (int i = 0; i < users.length; i++)
                {
                    if(users[i]==null)
                    {
                        System.out.println("密码或账号错误，将返回上一界面");
                        return null;
                    }
                    if(users[i].getBankId().equals(id) && users[i].getPassWord().equals(password))
                    {
                        System.out.println("登录成功！");
                        User u=users[i];
                        return u;
                    }
                }

            }
            else if("return".equals(comdom))
            {
                return null;
            }
            else
            {
                System.out.println("验证码错误！将重新输入验证码，或输入return退出登录界面");
            }
        }
    }
    /*存款*/
    //输入金额存入个人账户。
    public static boolean Deposit(User u,Scanner sc)
    {
        System.out.println("请输入存款金额：");
        double gold=sc.nextDouble();
        u.deposit(gold);
        System.out.println("存储成功！当前余额："+u.getBalance());
        return true;
    }
    /*取款*/
    //从个人账户中取出对应金额，账户余额减少。 要判断取出的金额是否大于此时余额，大于则取款失败。
    public static boolean WithdrawMoney(User u,Scanner sc)
    {
        System.out.println("请输入取款金额：");
        double gold = sc.nextDouble();
        boolean flag = u.ZhuangZhang(gold);
        if(flag)
            System.out.println("取款成功！当前余额："+u.getBalance());
        else
            System.out.println("取款失败！当前余额："+u.getBalance());
        return flag;
    }
    /*转账*/
    //输入接收方的id号，从己方账户中取款。
    public static void Transfer_Accounts(User user) //转账
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要转入的银行账户：");
        String id=sc.next();
        System.out.println("请输入要转账的金额：");
        double gold=sc.nextDouble();
        boolean bool = user.ZhuangZhang(gold);
        if(!bool)
        {
            System.out.println("转账失败！当前余额："+user.getBalance());
        }
        else
        {
            System.out.println("转账成功！当前余额："+user.getBalance());
        }
    }

    /*查询*/
    //- 显示本用户的id信息与姓名。
    //- 显示账户余额。
    public static void Show(User u,Scanner sc)
    {

        System.out.println("输入：1， 显示本用户的id信息与姓名\n输入：2， 显示账户余额");
        int Case=sc.nextInt();
        switch(Case)
        {
            case 1:
                System.out.println("姓名："+u.getName());
                System.out.println("ID："+u.getBankId());
                break;
            case 2:
                System.out.println("当前余额："+u.getBalance());
                break;
        }
    }
}
