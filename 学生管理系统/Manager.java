import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Student> studentList=new ArrayList<Student>();
    private String  managerName;
    private String managerPassword;

    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getManagerPassword() {
        return managerPassword;
    }
    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
    Manager(String name,String password){//管理员从磁盘中读取所有学生信息
        managerName=name;
        managerPassword=password;
        try{
            BufferedReader br=new BufferedReader(new FileReader("student.txt"));
            for(String s=br.readLine();s!=null;s=br.readLine()){
                String sArray[]=s.split(",");
                studentList.add(new Student(sArray[0],sArray[1],sArray[2]));
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void list(){
        if(studentList.isEmpty()){
            System.out.print("暂无学生记录!\n");
        }else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println(studentList.get(i));
            }
        }
    }
    public void add(){
        Student stu = new Student();
        Scanner read = new Scanner(System.in);
        System.out.print("请输入学号:");
        stu.setId(read.nextLine());
        System.out.print("请输入姓名:");
        stu.setName(read.nextLine());
        System.out.print("请输入电话号码:");
        stu.setCellphone(read.nextLine());
        studentList.add(stu);
        System.out.print(stu + "插入成功!\n");
    }
    public Student find(String id){
        for(int i=0;i<studentList.size();i++){
            Student s=studentList.get(i);
            if(id.equals(s.getId())){
                return s;
            }
        }
        return null;
    }
    public void remove(String id){
        Student stu =find(id);
        if(stu==null){
            System.out.print("您输入的信息有误，学生不存在!\n");
        }else{
            studentList.remove(stu);
            System.out.print(stu+"删除成功!\n");
        }
    }
    public void save(){//更新系统信息到磁盘文件中
        try{
            BufferedWriter bw =new BufferedWriter(new FileWriter("student.txt"));
            for(int i=0;i<studentList.size();i++){
                bw.write(studentList.get(i)+"\r\n");
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return managerName+","+managerPassword;
    }
}
