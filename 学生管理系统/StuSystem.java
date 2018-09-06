import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class StuSystem {
    public static Manager login(){//管理员登陆
        String Add="addM";
        String Remove="removeM";
        String Else="else";
        String List="List";
        Manager kawhi=new Manager("kawhi","123456");//终极管理员,可以注册和删除其他管理员
        ArrayList<Manager> managers=new ArrayList<Manager>();//管理员列表
        try{//读取所有管理员信息,终极管理员不在其中
            BufferedReader br=new BufferedReader(new FileReader("manager.txt"));
            for(String s=br.readLine();s!=null;s=br.readLine()){
                String sArray[]=s.split(",");
                managers.add(new Manager(sArray[0],sArray[1]));
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("***欢迎来到学生管理系统***");
        System.out.print("请输入您的用户名:");
        Scanner read=new Scanner(System.in);
        while(true){
            String Mname=read.nextLine();
            if(kawhi.getManagerName().equals(Mname)){//终极管理员
                System.out.print("请输入密码:");
                while(true){
                    if(kawhi.getManagerPassword().equals(read.nextLine())){
                        System.out.println(kawhi.getManagerName()+",欢迎登陆!");
                        System.out.println("添加管理员:"+Add+"\n删除管理员:"+Remove+"\n查看所有管理员:"+List+"\n进入学生管理界面:"+Else);
                            while(true){
                                System.out.print("<终极管理员>"+kawhi.getManagerName()+":");
                                String s=read.nextLine();
                                if(Add.equals(s)){//添加管理员
                                    System.out.print("请输入用户名:");
                                    String Name=read.nextLine();
                                    System.out.print("请输入密码:");
                                    String Password=read.nextLine();
                                    Manager Addm=new Manager(Name,Password);
                                    managers.add(Addm);
                                    System.out.println(Addm.getManagerName()+"成为新的管理员!");
                                }else if(Remove.equals(s)){//删除管理员
                                    System.out.print("请输入要删除的用户名:");
                                    for(int i=0;i<managers.size();i++){
                                        if(managers.get(i).equals(read.nextLine())){//找到要删除的管理员
                                            managers.remove(i);//删除
                                            break;
                                        }
                                    }
                                    System.out.println("管理员不存在!");
                                }else if(Else.equals(s)){
                                    try{
                                        BufferedWriter bw =new BufferedWriter(new FileWriter("manager.txt"));
                                        for(int i=0;i<managers.size();i++){
                                            bw.write(managers.get(i)+"\r\n");
                                        }
                                        bw.close();
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    System.out.println("欢迎来到学生管理界面!");
                                    return kawhi;
                                }else if(List.equals(s)){
                                    for(int i=0;i<managers.size();i++){
                                        System.out.println(managers.get(i).getManagerName());
                                    }
                                }else{
                                    System.out.print("非法命令!请重新输入操作命令:");
                                }
                            }
                        }else{
                            System.out.print("密码错误,请重新输入密码:");
                        }
                    }
            }else{//一般管理员
                for(int i=0;i<managers.size();i++){
                    if(managers.get(i).getManagerName().equals(Mname)){
                        System.out.print("请输入密码:");
                        while(true){
                            String Mpassword=read.nextLine();
                            if(managers.get(i).getManagerPassword().equals(Mpassword)){
                                System.out.println("登陆成功!欢迎来到学生管理界面!");
                                return managers.get(i);
                            }else{
                                System.out.print("密码错误,请重新输入密码:");
                            }
                        }
                    }
                }
                System.out.print("用户名不存在,请重新输入:");
            }
        }
    }
   public static void main(String[] s){
        Manager manager=login();
        String LIST="list";
       String ADD="add";
       String FIND="find";
       String Remove="remove";
       String SHUTDOWN="shutdown";
       System.out.println("添加学生信息:add\n查找学生:find\n查看所有学生:list\n删除学生信息:remove\n退出系统:shutdown");
       Scanner input=new Scanner(System.in);
       while(true){
           System.out.print("<学生管理系统>:");
           String cmd=input.nextLine();
           if(LIST.equals(cmd)){//list命令
               manager.list();
           }
           else if(ADD.equals(cmd)){
               manager.add();
           }
           else if(FIND.equals(cmd)){
               Student stu=new Student();
               System.out.print("请输入学号:");
               stu=manager.find(input.nextLine());
               if(stu!=null){
                   System.out.print("学生信息:"+stu+"\n");
               }else {
                   System.out.print("暂无学生信息!\n");
               }
           }
           else if(SHUTDOWN.equals(cmd)){
               manager.save();//信息更新到磁盘里
               break;
           }else if(Remove.equals(cmd)){
               System.out.print("请输入学号:");
               manager.remove(input.nextLine());
           } else {
               System.out.print("非法命令，请重新输入！\n");
           }
       }
   }
}
