
public class Borrowbook extends MyThread{
	Borrowbook(String name,Book book){//借书线程构造方法
		super(name,book);
	}
    public void run() {
    	    try {
    	    Thread.sleep((int)Math.random()*1000);//随机阻塞一段时间
    	    synchronized(book) {//使用book进行同步控制
    		while(book.getAmount()==0) {//如果库存为0，阻塞当前借书线程
    			System.out.println("当前库存为0,"+Thread.currentThread().getName()+"被阻塞");
    			book.wait();//阻塞当前借书线程
    		}
    		book.operation(-1);//执行借书操作	
    		flag=true;//当前线程运行结束
    	    }
    		}catch(InterruptedException e) {
    			e.printStackTrace();//中断异常
    		}
    	    }
}

