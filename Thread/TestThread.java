
public class TestThread {
	public static void main(String[] args) {
		 Book book = new Book(1);//��ʼ���鱾�Ŀ����Ϊ1
		 Thread Threadlist[] = new Thread[10];
		 Threadlist[0] = new Borrowbook("�����߳�1",book);
		 Threadlist[1] = new Borrowbook("�����߳�2",book);
		 Threadlist[2] = new Borrowbook("�����߳�3",book);
		 Threadlist[3] = new Borrowbook("�����߳�4",book);
		 Threadlist[4] = new Borrowbook("�����߳�5",book);
		 Threadlist[5] = new Returnbook("�����߳�1",book);
		 Threadlist[6] = new Returnbook("�����߳�2",book);
		 Threadlist[7] = new Returnbook("�����߳�3",book);
		 Threadlist[8] = new Returnbook("�����߳�4",book);
		 Threadlist[9] = new Returnbook("�����߳�5",book);
        for(int i=0;i<10;i++) {
        	Threadlist[i].start();//����10���߳�
        }
	}
}
