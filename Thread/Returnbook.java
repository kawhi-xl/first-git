
public class Returnbook extends Thread{
	private Book book;
    Returnbook(String name,Book book){//还书线程构造方法
    	super(name);
    	this.book=book;
    }
    public void run() {
    		try {
    		Thread.sleep((int)Math.random()*10000);//随机的阻塞一段时间，使线程之间交叉进行
    		if(book.getAmount()==3) {
    			System.out.println("书本库存已满，无需还书,"+Thread.currentThread().getName()+"提前终止");
    		}else {
    		book.Return();//还书
    		book.operation(1);//执行还书操作
    		}
    		}catch(InterruptedException e) {
    			e.printStackTrace();//中断异常
    		}      	
    }
}
