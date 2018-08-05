
public class Borrowbook extends Thread{
	private Book book;
    Borrowbook(String name,Book book){//借书线程构造方法
    	super(name);
    	this.book=book;
    }
    public void run() {
    		try {
    	    Thread.sleep((int)Math.random()*10000);//随机的阻塞一段时间，使线程之间交叉进行
    		book.Borrow();//借书
    		book.operation(-1);//执行借书操作		
    		}catch(InterruptedException e) {
    			e.printStackTrace();//中断异常
    		}  	       	
    }
}
