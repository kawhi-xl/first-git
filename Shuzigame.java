import java.util.*;
public class Shuzigame {

	public static void main(String[] args) {
		String a1="begin";
		String a2="shutdown";
		String a3="continue";
		int i=0;                   //ÿ��һ�ز�����Χ����һ������һ��Ϊ0-64
		int min=10000;             //��¼������ٲ²����
		System.out.println("������begin��ʼ��Ϸ:");
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		if(s.equals(a1))
		do{
			i++; //����+1
			System.out.println("��ӭ������"+i+"��");
			int c=0;  //��¼ÿһ����Ϸ�׶εĲ²����
			int m=(int)(Math.random()*100000)%(64*i);  //����ÿ����Ϸ�׶ζ�Ӧ��Χ�ڵ������
			int n=input.nextInt();
			c++;
			while(n!=m) {
				if(n>m) {
					System.out.println("���µ�������!");
				}
				else {
					System.out.println("���µ���С��!");
				}
				n=input.nextInt();   //�µĲ��ԣ������£��²����+1
				c++;       
			}
			if(c<min)  min=c;
			System.out.println("����ȷ!�����ι��²�"+c+"��!");
			System.out.println("������һ��������continue,������Ϸ������shutdown");
			input=new Scanner(System.in);
			s=input.nextLine();
		}while(!s.equals(a2));
		System.out.println("��������������"+min+"��");
	}
}
