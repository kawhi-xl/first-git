
public class Borrowbook extends Thread{
	private Book book;
    Borrowbook(String name,Book book){//�����̹߳��췽��
    	super(name);
    	this.book=book;
    }
    public void run() {
    		try {
    	    Thread.sleep((int)Math.random()*10000);//���������һ��ʱ�䣬ʹ�߳�֮�佻�����
    		book.Borrow();//����
    		book.operation(-1);//ִ�н������		
    		}catch(InterruptedException e) {
    			e.printStackTrace();//�ж��쳣
    		}  	       	
    }
}
