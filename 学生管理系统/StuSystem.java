import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class StuSystem {
    public static Manager login(){//����Ա��½
        String Add="addM";
        String Remove="removeM";
        String Else="else";
        String List="List";
        Manager kawhi=new Manager("kawhi","123456");//�ռ�����Ա,����ע���ɾ����������Ա
        ArrayList<Manager> managers=new ArrayList<Manager>();//����Ա�б�
        try{//��ȡ���й���Ա��Ϣ,�ռ�����Ա��������
            BufferedReader br=new BufferedReader(new FileReader("manager.txt"));
            for(String s=br.readLine();s!=null;s=br.readLine()){
                String sArray[]=s.split(",");
                managers.add(new Manager(sArray[0],sArray[1]));
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("***��ӭ����ѧ������ϵͳ***");
        System.out.print("�����������û���:");
        Scanner read=new Scanner(System.in);
        while(true){
            String Mname=read.nextLine();
            if(kawhi.getManagerName().equals(Mname)){//�ռ�����Ա
                System.out.print("����������:");
                while(true){
                    if(kawhi.getManagerPassword().equals(read.nextLine())){
                        System.out.println(kawhi.getManagerName()+",��ӭ��½!");
                        System.out.println("��ӹ���Ա:"+Add+"\nɾ������Ա:"+Remove+"\n�鿴���й���Ա:"+List+"\n����ѧ���������:"+Else);
                            while(true){
                                System.out.print("<�ռ�����Ա>"+kawhi.getManagerName()+":");
                                String s=read.nextLine();
                                if(Add.equals(s)){//��ӹ���Ա
                                    System.out.print("�������û���:");
                                    String Name=read.nextLine();
                                    System.out.print("����������:");
                                    String Password=read.nextLine();
                                    Manager Addm=new Manager(Name,Password);
                                    managers.add(Addm);
                                    System.out.println(Addm.getManagerName()+"��Ϊ�µĹ���Ա!");
                                }else if(Remove.equals(s)){//ɾ������Ա
                                    System.out.print("������Ҫɾ�����û���:");
                                    for(int i=0;i<managers.size();i++){
                                        if(managers.get(i).equals(read.nextLine())){//�ҵ�Ҫɾ���Ĺ���Ա
                                            managers.remove(i);//ɾ��
                                            break;
                                        }
                                    }
                                    System.out.println("����Ա������!");
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
                                    System.out.println("��ӭ����ѧ���������!");
                                    return kawhi;
                                }else if(List.equals(s)){
                                    for(int i=0;i<managers.size();i++){
                                        System.out.println(managers.get(i).getManagerName());
                                    }
                                }else{
                                    System.out.print("�Ƿ�����!�����������������:");
                                }
                            }
                        }else{
                            System.out.print("�������,��������������:");
                        }
                    }
            }else{//һ�����Ա
                for(int i=0;i<managers.size();i++){
                    if(managers.get(i).getManagerName().equals(Mname)){
                        System.out.print("����������:");
                        while(true){
                            String Mpassword=read.nextLine();
                            if(managers.get(i).getManagerPassword().equals(Mpassword)){
                                System.out.println("��½�ɹ�!��ӭ����ѧ���������!");
                                return managers.get(i);
                            }else{
                                System.out.print("�������,��������������:");
                            }
                        }
                    }
                }
                System.out.print("�û���������,����������:");
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
       System.out.println("���ѧ����Ϣ:add\n����ѧ��:find\n�鿴����ѧ��:list\nɾ��ѧ����Ϣ:remove\n�˳�ϵͳ:shutdown");
       Scanner input=new Scanner(System.in);
       while(true){
           System.out.print("<ѧ������ϵͳ>:");
           String cmd=input.nextLine();
           if(LIST.equals(cmd)){//list����
               manager.list();
           }
           else if(ADD.equals(cmd)){
               manager.add();
           }
           else if(FIND.equals(cmd)){
               Student stu=new Student();
               System.out.print("������ѧ��:");
               stu=manager.find(input.nextLine());
               if(stu!=null){
                   System.out.print("ѧ����Ϣ:"+stu+"\n");
               }else {
                   System.out.print("����ѧ����Ϣ!\n");
               }
           }
           else if(SHUTDOWN.equals(cmd)){
               manager.save();//��Ϣ���µ�������
               break;
           }else if(Remove.equals(cmd)){
               System.out.print("������ѧ��:");
               manager.remove(input.nextLine());
           } else {
               System.out.print("�Ƿ�������������룡\n");
           }
       }
   }
}
