
public class Borrowbook extends MyThread{
	Borrowbook(String name,Book book){//�����̹߳��췽��
		super(name,book);
	}
    public void run() {
    	    try {
    	    Thread.sleep((int)Math.random()*1000);//�������һ��ʱ��
    	    synchronized(book) {//ʹ��book����ͬ������
    		while(book.getAmount()==0) {//������Ϊ0��������ǰ�����߳�
    			System.out.println("��ǰ���Ϊ0,"+Thread.currentThread().getName()+"������");
    			book.wait();//������ǰ�����߳�
    		}
    		book.operation(-1);//ִ�н������	
    		flag=true;//��ǰ�߳����н���
    	    }
    		}catch(InterruptedException e) {
    			e.printStackTrace();//�ж��쳣
    		}
    	    }
}

