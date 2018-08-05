
public class Returnbook extends MyThread{
    Returnbook(String name,Book book){//还书线程构造方法
    	super(name,book);
    }
    public void run() {
    	try {
    		Thread.sleep((int)Math.random()*1000);//随机阻塞一段时间
    	    synchronized(book) {//使用book进行同步控制
    		book.notifyAll();
    		if(book.getAmount()==3) {
    			System.out.println("书本库存已满，无需还书,"+Thread.currentThread().getName()+"提前终止");
    		}else {
    		book.operation(1);//执行还书操作
    		}
    	}
    	    flag=true;//当前线程运行结束
    	}catch(InterruptedException e) {
			e.printStackTrace();//中断异常
		}
    }
}
