package ��̨2;
public class Zaikeche extends Car{
	int people;//����ؿ���
	Zaikeche(int i,String name,int money,int people){//��ʼ�����췽��
		super(i,name,money);//��ʾ���ø��๹�췽��
		this.people=people;
	}
	public void show() {//չʾ������Ϣ��ʾ����
		System.out.println(super.i+"��"+super.name+"���⳵����Ϊ"+super.money+"Ԫ/(��.��),�ؿ���Ϊ"+people+"��");
	}
}
