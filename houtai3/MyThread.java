
public class MyThread extends Thread{
	boolean flag=false;//�߳����н����ı�־
    Book book;
    MyThread(String name,Book book){//�̹߳��췽��
    	super(name);
    	this.book=book;
    }
    public boolean getFlag() {//�����߳��Ƿ����н���
    	return flag;
    }
}
