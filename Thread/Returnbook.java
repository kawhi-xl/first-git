
public class Returnbook extends Thread{
	private Book book;
    Returnbook(String name,Book book){//�����̹߳��췽��
    	super(name);
    	this.book=book;
    }
    public void run() {
    		try {
    		Thread.sleep((int)Math.random()*10000);//���������һ��ʱ�䣬ʹ�����߳̽������
    		if(book.getAmount()==3) {
    			System.out.println("�鱾������������軹��,"+Thread.currentThread().getName()+"��ǰ��ֹ");
    		}else {
    		book.Return();//����
    		book.operation(1);//ִ�л������
    		}
    		}catch(InterruptedException e) {
    			e.printStackTrace();//�ж��쳣
    		}      	
    }
}
