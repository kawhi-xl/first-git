
public class TestThread {
	public static void main(String[] args) {
		 Book book = new Book(1);//初始化书本的库存量为1
		 Thread Threadlist[] = new Thread[10];
		 Threadlist[0] = new Borrowbook("借书线程1",book);
		 Threadlist[1] = new Borrowbook("借书线程2",book);
		 Threadlist[2] = new Borrowbook("借书线程3",book);
		 Threadlist[3] = new Borrowbook("借书线程4",book);
		 Threadlist[4] = new Borrowbook("借书线程5",book);
		 Threadlist[5] = new Returnbook("还书线程1",book);
		 Threadlist[6] = new Returnbook("还书线程2",book);
		 Threadlist[7] = new Returnbook("还书线程3",book);
		 Threadlist[8] = new Returnbook("还书线程4",book);
		 Threadlist[9] = new Returnbook("还书线程5",book);
        for(int i=0;i<10;i++) {
        	Threadlist[i].start();//启动10个线程
        }
	}
}
