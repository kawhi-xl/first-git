import java.util.Scanner;
public class Shuzigame{

	public static void main(String[] args) {
		String BEGIN="begin";
		String SHUTDOWN="shutdown";
		String CONTINUE="continue";
		int i=0;                   //每过一关猜数范围扩大一倍，第一关为0-64
		int min=10000;             //记录最后最少猜测次数
		int j=0;                   //记录最少猜测次数的关卡
		System.out.println("请输入"+BEGIN+"开始游戏:");
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		if(BEGIN.equals(s))
		do{
			i++; //关数+1
			System.out.println("欢迎来到第"+i+"关,猜数范围是0-"+64*i);
			int c=0;  //记录每一个游戏阶段的猜测次数
			int m=(int)(Math.random()*100000)%(64*i+1);  //产生每个游戏阶段对应范围内的随机数
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
			if(c<min)  {
				min=c;
				j=i;    //记录当前最小猜测次数及对应的关卡
			}        
			System.out.println("答案正确!您在本关猜测"+c+"次!当前最少猜测次数为"+min+"(第"+j+"关)");
			System.out.println("进入下一关请输入"+CONTINUE+"结束游戏请输入"+SHUTDOWN);
			input=new Scanner(System.in);
			s=input.nextLine();
		}while(!SHUTDOWN.equals(s));
		System.out.println("游戏结束!恭喜您共闯过"+i+"关,猜测次数最少为"+min+"(第"+j+"关)!");
	}
}
