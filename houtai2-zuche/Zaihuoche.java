package 后台2;

public class Zaihuoche extends Car{
       double weight; //载货量（吨）
       Zaihuoche(int i,String name,int money,double weight){//初始化构造方法
    	   super(i,name,money);//显示调用父类构造方法
    	   this.weight=weight;
       }
       public void show() {//显示方法
   		System.out.println(super.i+"号"+super.name+"的租车费用为"+super.money+"元/(车.天),载货量为"+weight+"吨");
   	   }
}
