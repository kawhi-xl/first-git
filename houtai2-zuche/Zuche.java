package ��̨2;
import java.util.*;
public class Zuche {
	public static void main(String[] args) {
		Zaikeche Zaikelist[] = new Zaikeche[3];
		Zaikelist[0] = new Zaikeche(1,"С�γ�",40,4);
		Zaikelist[1] = new Zaikeche(2,"�����",65,7);
		Zaikelist[2] = new Zaikeche(3,"��ͳ�",180,20);	
		//�ؿͳ�����������ֱ�Ϊ1��С�γ���2���������3�Ŵ�ͳ�
		Zaihuoche Zaihuolist[] = new Zaihuoche[3];
        Zaihuolist[0] = new Zaihuoche(4,"������",30,1.5);
        Zaihuolist[1] = new Zaihuoche(5,"������",47,2.5);
        Zaihuolist[2] = new Zaihuoche(6,"��ʽ��",80,4.5);
        //�ػ�������������ֱ���4�ŵ�������5�Ÿ�������6����ʽ��
        Pikache Pikalist[] = new Pikache[2];
        Pikalist[0] = new Pikache(7,"��ʽƤ����",60,5,1);
        Pikalist[1] = new Pikache(8,"��ʽƤ����",60,2,3);
        //Ƥ��������������ֱ���7����ʽƤ������8����ʽƤ����
        System.out.println("�װ��Ŀͻ����ã����೵������Ϣ���£�");
        for(int i=0;i<3;i++) {
        	Zaikelist[i].show();
        }
        for(int i=0;i<3;i++) {
        	Zaihuolist[i].show();                  //չʾ���������������Ϣ
        }
        for(int i=0;i<2;i++) {
        	Pikalist[i].show();
        }
        //=======================================================
        int number[] = new int[8];//��¼�����������������
        int time[] = new int[8];//��¼�����������������
        int people=0;//��¼��������⳵���ؿ���
        double weight=0;//��¼��������⳵���ػ���
        int money=0;//��¼��������⳵����
        int num=0;//��¼���������
        Scanner input = new Scanner(System.in);
        //===========================================================
        for(int i=0;i<8;i++) {
        	if(i<3) {//�ؿͳ�
        		number[i]=Zaikelist[i].getNum(i+1);
        	}
        	else if(i<6) { //�ػ���                               //��ȡ�����������������
        		number[i]=Zaihuolist[i-3].getNum(i+1);
        	}
        	else {//Ƥ����
        		number[i]=Pikalist[i-6].getNum(i+1);
        	}
        }
        //===========================================================
        for(int i=0;i<8;i++) {
        	if(number[i]!=0) {//�������Ҫ�����
        		if(i<3) {//���ؿͳ�
        		    System.out.println("������"+(i+1)+"��"+Zaikelist[i].name+"���������:");
        		}
        		else if(i<6) {//���ػ���
        			System.out.println("������"+(i+1)+"��"+Zaihuolist[i-3].name+"���������:");
        		}
        		else {//��Ƥ����
        			System.out.println("������"+(i+1)+"��"+Pikalist[i-6].name+"���������:");
        		}
            	time[i]=input.nextInt();
        	}
        }
        //=========================================================================
        System.out.println("�˴�ҵ������:");
        for(int i=0;i<8;i++) {
        	if(number[i]!=0) {//�г��������
        		if(i<3) {//���ؿͳ�
        			people+=(Zaikelist[i].people*number[i]);//ͳ���ؿͳ����ؿ���(�������ؿ�����*��������)
        			money+=(Zaikelist[i].money*number[i]*time[i]);//ͳ����Ӧ�����
        			System.out.println((i+1)+"��("+Zaikelist[i].name+")�����������"+number[i]+"��,���������"+time[i]+"��");
        		}
        		else if(i<6) {//���ػ���
        			weight+=(Zaihuolist[i-3].weight*number[i]);//ͳ���ػ������ػ���(�ػ�����*����)
        			money+=(Zaihuolist[i-3].money*number[i]*time[i]);
        			System.out.println((i+1)+"��("+Zaihuolist[i-3].name+")�����������"+number[i]+"��,���������"+time[i]+"��");
        		}
        		else {//��Ƥ����
        			people+=(Pikalist[i-6].people*number[i]);
        			weight+=(Pikalist[i-6].weight*number[i]);//Ƥ������ͬʱ�����ؿͺ��ػ����������Ҫͳ��
        			money+=(Pikalist[i-6].money*number[i]*time[i]);
        			System.out.println((i+1)+"��("+Pikalist[i-6].name+")�����������"+number[i]+"��,���������"+time[i]+"��");
        		}
        		num+=number[i];//ͳ�Ƴ�������
        	}
        }
        System.out.println("�����ؿ���Ϊ"+people+"��");
        System.out.println("�����ػ���Ϊ"+weight+"��");
        System.out.println("��賵����������"+num+"��");
        System.out.println("���˴�ҵ��������"+money+"Ԫ");
        input.nextLine();//�س���������
        input.close();
	}      
}
