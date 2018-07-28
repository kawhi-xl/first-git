package 后台2;
import java.util.Scanner;

public class Car {//初始化构造方法
	     int i;  //车辆序号
	     String name;//车辆名称
         int money;  //租用费用（元/（车.天）	）
         Car(int i,String name,int money){//初始化构造方法
        	 this.i=i;
        	 this.name=name;
        	 this.money=money;
         }
         public int getNum(int i) {//获取租借数量
     		System.out.println("请输入"+i+"号("+name+")的租借数量(不能为负数和小数):");
     		Scanner input = new Scanner(System.in);
     		while(true) {
     			double read=input.nextDouble();
     			if(read<0 || (read%1!=0)) {//如果输入的是负数或者是小数
         			System.out.println("您输入的数据有误，请重新输入(不能为负数和小数):");
         		}
         		else {
         			return (int)read;
         		}
     		}
     	}
}
