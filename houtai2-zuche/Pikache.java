package ��̨2;

public class Pikache extends Car {
    int people; //�ؿ���
    int weight;//�ػ���
    Pikache(int i,String name,int money,int people,int weight){//��ʼ�����췽��
    	super(i,name,money);//��ʾ���ø��๹�췽��
    	this.people=people;
    	this.weight=weight;
    }
    public void show() {//��ʾ����
		System.out.println(super.i+"��"+super.name+"���⳵����Ϊ"+super.money+"Ԫ/(��.��),�ؿ���Ϊ"+people+"��,�ػ���Ϊ"+weight+"��");
	}
}
