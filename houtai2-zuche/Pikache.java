package 后台2;

public class Pikache extends Car {
    int people; //载客数
    int weight;//载货量
    Pikache(int i,String name,int money,int people,int weight){//初始化构造方法
    	super(i,name,money);//显示调用父类构造方法
    	this.people=people;
    	this.weight=weight;
    }
    public void show() {//显示方法
		System.out.println(super.i+"号"+super.name+"的租车费用为"+super.money+"元/(车.天),载客量为"+people+"人,载货量为"+weight+"吨");
	}
}
