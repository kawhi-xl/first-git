package ��̨2;
import java.util.Scanner;

public class Car {//��ʼ�����췽��
	     int i;  //�������
	     String name;//��������
         int money;  //���÷��ã�Ԫ/����.�죩	��
         Car(int i,String name,int money){//��ʼ�����췽��
        	 this.i=i;
        	 this.name=name;
        	 this.money=money;
         }
         public int getNum(int i) {//��ȡ�������
     		System.out.println("������"+i+"��("+name+")���������(����Ϊ������С��):");
     		Scanner input = new Scanner(System.in);
     		while(true) {
     			double read=input.nextDouble();
     			if(read<0 || (read%1!=0)) {//���������Ǹ���������С��
         			System.out.println("�������������������������(����Ϊ������С��):");
         		}
         		else {
         			return (int)read;
         		}
     		}
     	}
}
