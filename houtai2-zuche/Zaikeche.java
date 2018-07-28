package 后台2;
public class Zaikeche extends Car{
	int people;//最大载客量
	Zaikeche(int i,String name,int money,int people){//初始化构造方法
		super(i,name,money);//显示调用父类构造方法
		this.people=people;
	}
	public void show() {//展示车辆信息显示方法
		System.out.println(super.i+"号"+super.name+"的租车费用为"+super.money+"元/(车.天),载客量为"+people+"人");
	}
}
