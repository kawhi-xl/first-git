package ��̨2;

public class Zaihuoche extends Car{
       double weight; //�ػ������֣�
       Zaihuoche(int i,String name,int money,double weight){//��ʼ�����췽��
    	   super(i,name,money);//��ʾ���ø��๹�췽��
    	   this.weight=weight;
       }
       public void show() {//��ʾ����
   		System.out.println(super.i+"��"+super.name+"���⳵����Ϊ"+super.money+"Ԫ/(��.��),�ػ���Ϊ"+weight+"��");
   	   }
}
