
public class MyThread extends Thread{
	boolean flag=false;//线程运行结束的标志
    Book book;
    MyThread(String name,Book book){//线程构造方法
    	super(name);
    	this.book=book;
    }
    public boolean getFlag() {//返回线程是否运行结束
    	return flag;
    }
}
