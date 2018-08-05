
public class Book {
	   private int amount;// 记录书本的库存量
	   Book(int amount){//初始化构造方法
		   this.amount=amount;
	   }
	   public synchronized int getAmount() {//获取库存量,互斥操作，需要加上对象锁
		   return amount;
	   }
	   public synchronized void operation(int x) {//是互斥操作，需要加上对象锁（执行一次借书或还书操作）
		   amount+=x;//写回操作结束后的库存量
		   System.out.println(Thread.currentThread().getName()+"操作执行完成，当前书本剩余库存为"+amount);   
	   }
} 
