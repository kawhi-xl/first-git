
public class Returnbook extends MyThread{
    Returnbook(String name,Book book){//�����̹߳��췽��
    	super(name,book);
    }
    public void run() {
    	try {
    		Thread.sleep((int)Math.random()*1000);//�������һ��ʱ��
    	    synchronized(book) {//ʹ��book����ͬ������
    		book.notifyAll();
    		if(book.getAmount()==3) {
    			System.out.println("�鱾������������軹��,"+Thread.currentThread().getName()+"��ǰ��ֹ");
    		}else {
    		book.operation(1);//ִ�л������
    		}
    	}
    	    flag=true;//��ǰ�߳����н���
    	}catch(InterruptedException e) {
			e.printStackTrace();//�ж��쳣
		}
    }
}
