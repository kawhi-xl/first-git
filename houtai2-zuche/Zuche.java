package 后台2;
import java.util.*;
public class Zuche {
	public static void main(String[] args) {
		Zaikeche Zaikelist[] = new Zaikeche[3];
		Zaikelist[0] = new Zaikeche(1,"小轿车",40,4);
		Zaikelist[1] = new Zaikeche(2,"面包车",65,7);
		Zaikelist[2] = new Zaikeche(3,"大巴车",180,20);	
		//载客车的三个对象分别为1号小轿车，2号面包车和3号大巴车
		Zaihuoche Zaihuolist[] = new Zaihuoche[3];
        Zaihuolist[0] = new Zaihuoche(4,"低栏车",30,1.5);
        Zaihuolist[1] = new Zaihuoche(5,"高栏车",47,2.5);
        Zaihuolist[2] = new Zaihuoche(6,"厢式车",80,4.5);
        //载货车的三个对象分别是4号低栏车，5号高栏车和6号厢式车
        Pikache Pikalist[] = new Pikache[2];
        Pikalist[0] = new Pikache(7,"日式皮卡车",60,5,1);
        Pikalist[1] = new Pikache(8,"美式皮卡车",60,2,3);
        //皮卡车的两个对象分别是7号日式皮卡车和8号美式皮卡车
        System.out.println("亲爱的客户您好！各类车辆的信息如下：");
        for(int i=0;i<3;i++) {
        	Zaikelist[i].show();
        }
        for(int i=0;i<3;i++) {
        	Zaihuolist[i].show();                  //展示各个车辆的租借信息
        }
        for(int i=0;i<2;i++) {
        	Pikalist[i].show();
        }
        //=======================================================
        int number[] = new int[8];//记录各个车辆的租借数量
        int time[] = new int[8];//记录各个车辆的租借天数
        int people=0;//记录最后总体租车的载客量
        double weight=0;//记录最后总体租车的载货量
        int money=0;//记录最后总体租车费用
        int num=0;//记录最后车辆总数
        Scanner input = new Scanner(System.in);
        //===========================================================
        for(int i=0;i<8;i++) {
        	if(i<3) {//载客车
        		number[i]=Zaikelist[i].getNum(i+1);
        	}
        	else if(i<6) { //载货车                               //获取各个车辆的租借数量
        		number[i]=Zaihuolist[i-3].getNum(i+1);
        	}
        	else {//皮卡车
        		number[i]=Pikalist[i-6].getNum(i+1);
        	}
        }
        //===========================================================
        for(int i=0;i<8;i++) {
        	if(number[i]!=0) {//如果车辆要被租借
        		if(i<3) {//是载客车
        		    System.out.println("请输入"+(i+1)+"号"+Zaikelist[i].name+"的租借天数:");
        		}
        		else if(i<6) {//是载货车
        			System.out.println("请输入"+(i+1)+"号"+Zaihuolist[i-3].name+"的租借天数:");
        		}
        		else {//是皮卡车
        			System.out.println("请输入"+(i+1)+"号"+Pikalist[i-6].name+"的租借天数:");
        		}
            	time[i]=input.nextInt();
        	}
        }
        //=========================================================================
        System.out.println("此次业务详情:");
        for(int i=0;i<8;i++) {
        	if(number[i]!=0) {//有车辆被租借
        		if(i<3) {//是载客车
        			people+=(Zaikelist[i].people*number[i]);//统计载客车的载客量(车辆的载客能力*车辆数量)
        			money+=(Zaikelist[i].money*number[i]*time[i]);//统计相应的租金
        			System.out.println((i+1)+"号("+Zaikelist[i].name+")的租借数量是"+number[i]+"辆,租借天数是"+time[i]+"天");
        		}
        		else if(i<6) {//是载货车
        			weight+=(Zaihuolist[i-3].weight*number[i]);//统计载货车的载货量(载货能力*数量)
        			money+=(Zaihuolist[i-3].money*number[i]*time[i]);
        			System.out.println((i+1)+"号("+Zaihuolist[i-3].name+")的租借数量是"+number[i]+"辆,租借天数是"+time[i]+"天");
        		}
        		else {//是皮卡车
        			people+=(Pikalist[i-6].people*number[i]);
        			weight+=(Pikalist[i-6].weight*number[i]);//皮卡车的同时具有载客和载货能力，两项都要统计
        			money+=(Pikalist[i-6].money*number[i]*time[i]);
        			System.out.println((i+1)+"号("+Pikalist[i-6].name+")的租借数量是"+number[i]+"辆,租借天数是"+time[i]+"天");
        		}
        		num+=number[i];//统计车辆数量
        	}
        }
        System.out.println("总体载客量为"+people+"人");
        System.out.println("总体载货量为"+weight+"吨");
        System.out.println("租借车辆的总数是"+num+"辆");
        System.out.println("您此次业务的租金是"+money+"元");
        input.nextLine();//回车结束程序
        input.close();
	}      
}
