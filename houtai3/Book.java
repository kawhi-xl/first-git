
public class Book {
	   private int amount;// ��¼�鱾�Ŀ����
	   Book(int amount){//��ʼ�����췽��
		   this.amount=amount;
	   }
	   public synchronized int getAmount() {//��ȡ�����,�����������Ҫ���϶�����
		   return amount;
	   }
	   public synchronized void operation(int x) {//�ǻ����������Ҫ���϶�������ִ��һ�ν�����������
		   amount+=x;//д�ز���������Ŀ����
		   System.out.println(Thread.currentThread().getName()+"����ִ����ɣ���ǰ�鱾ʣ����Ϊ"+amount);   
	   }
} 
