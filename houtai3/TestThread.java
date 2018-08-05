
public class TestThread {
	public static void main(String[] args) {
		 Book book = new Book(1);//初始化书本的库存量为1
		 MyThread MyThreadlist[] = new MyThread[10];
		 MyThreadlist[0] = new Borrowbook("借书线程1",book);
		 MyThreadlist[1] = new Borrowbook("借书线程2",book);
		 MyThreadlist[2] = new Borrowbook("借书线程3",book);
		 MyThreadlist[3] = new Borrowbook("借书线程4",book);
		 MyThreadlist[4] = new Borrowbook("借书线程5",book);
		 MyThreadlist[5] = new Returnbook("还书线程1",book);
		 MyThreadlist[6] = new Returnbook("还书线程2",book);
		 MyThreadlist[7] = new Returnbook("还书线程3",book);
		 MyThreadlist[8] = new Returnbook("还书线程4",book);
		 MyThreadlist[9] = new Returnbook("还书线程5",book);
        for(int i=0;i<10;i++) {
        	MyThreadlist[i].start();//启动10个线程
        }
      //可能会出现上面5个还书线程全都结束了还有借书线程在阻塞中使程序阻塞,需要补充还书线程来唤醒被阻塞的借书线程
        while(true) {
        	int borrowNum=0;//统计借书线程未结束的数量
        	int returnNum=0;//统计还书线程未结束的数量
        	for(int i=0;i<10;i++) {
        		if(i<5) {//获取各个借书线程的状态(结束否)
        			if(!MyThreadlist[i].getFlag()) {//未结束
        				borrowNum++;
        			}
        		}
        		else {//获取各个还书线程的状态(结束否)
        			if(!MyThreadlist[i].getFlag()) {//未结束
        				returnNum++;
        			}
        		}
        	}
        	if(returnNum==0) {//还书线程全部结束了
        		if(borrowNum==0) {//借书线程也全部结束了
        			break;
        		}
        		else {//还有借书线程没有结束，可能是被阻塞无法唤醒，补充还书线程确保程序不会被阻塞
        			new Returnbook("补充还书线程",book).start();
        		}
        	}
        }
	}
}
