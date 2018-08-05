
public class Book {
	   private int amount;// 记录书本的库存量
	   Book(int amount){//初始化构造方法
		   this.amount=amount;
	   }
	   public synchronized int getAmount() {//获取库存量,互斥操作，需要加上对象锁
		   return amount;
	   }
	   public void Borrow() {//申请借书，如果没有书可以借，则被阻塞
		   synchronized(this) {
			   if(getAmount()==0) {
				   try {
					   System.out.println("当前库存量为0,暂无书本可以借出,"+Thread.currentThread().getName()+"被阻塞");
					   wait();//阻塞当前借书线程，等待还书线程唤醒
				   }catch(InterruptedException e) {
					   //中断异常
				   }
			   }
		   }
	   }
	   public void Return() {//还书，如果借书线程被阻塞，则唤醒借书线程
		   synchronized(this) {
			   notifyAll();//唤醒被阻塞的借书线程
		   }
	   }
	   public synchronized void operation(int x) {//是互斥操作，需要加上对象锁（执行一次借书或还书操作）
		   amount+=x;//写回操作结束后的库存量
		   System.out.println(Thread.currentThread().getName()+"操作执行完成，当前书本剩余库存为"+amount);   
	   }
} 
