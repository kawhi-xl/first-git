import java.util.*;
public class Shuzigame {

	public static void main(String[] args) {
		String a1="begin";
		String a2="shutdown";
		String a3="continue";
		int i=0;                   //每过一关猜数范围扩大一倍，第一关为0-64
		int min=10000;             //记录最后最少猜测次数
		System.out.println("请输入begin开始游戏:");
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		if(s.equals(a1))
		do{
			i++; //关数+1
			System.out.println("欢迎来到第"+i+"关");
			int c=0;  //记录每一个游戏阶段的猜测次数
			int m=(int)(Math.random()*100000)%(64*i);  //产生每个游戏阶段对应范围内的随机数
			int n=input.nextInt();
			c++;
			while(n!=m) {
				if(n>m) {
					System.out.println("您猜的数大了!");
				}
				else {
					System.out.println("您猜的数小了!");
				}
				n=input.nextInt();   //猜的不对，继续猜，猜测次数+1
				c++;       
			}
			if(c<min)  min=c;
			System.out.println("答案正确!您本次共猜测"+c+"次!");
			System.out.println("进入下一关请输入continue,结束游戏请输入shutdown");
			input=new Scanner(System.in);
			s=input.nextLine();
		}while(!s.equals(a2));
		System.out.println("您猜数最少用了"+min+"次");
	}
}
