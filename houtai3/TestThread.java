
public class TestThread {
	public static void main(String[] args) {
		 Book book = new Book(1);//��ʼ���鱾�Ŀ����Ϊ1
		 MyThread MyThreadlist[] = new MyThread[10];
		 MyThreadlist[0] = new Borrowbook("�����߳�1",book);
		 MyThreadlist[1] = new Borrowbook("�����߳�2",book);
		 MyThreadlist[2] = new Borrowbook("�����߳�3",book);
		 MyThreadlist[3] = new Borrowbook("�����߳�4",book);
		 MyThreadlist[4] = new Borrowbook("�����߳�5",book);
		 MyThreadlist[5] = new Returnbook("�����߳�1",book);
		 MyThreadlist[6] = new Returnbook("�����߳�2",book);
		 MyThreadlist[7] = new Returnbook("�����߳�3",book);
		 MyThreadlist[8] = new Returnbook("�����߳�4",book);
		 MyThreadlist[9] = new Returnbook("�����߳�5",book);
        for(int i=0;i<10;i++) {
        	MyThreadlist[i].start();//����10���߳�
        }
      //���ܻ��������5�������߳�ȫ�������˻��н����߳���������ʹ��������,��Ҫ���仹���߳������ѱ������Ľ����߳�
        while(true) {
        	int borrowNum=0;//ͳ�ƽ����߳�δ����������
        	int returnNum=0;//ͳ�ƻ����߳�δ����������
        	for(int i=0;i<10;i++) {
        		if(i<5) {//��ȡ���������̵߳�״̬(������)
        			if(!MyThreadlist[i].getFlag()) {//δ����
        				borrowNum++;
        			}
        		}
        		else {//��ȡ���������̵߳�״̬(������)
        			if(!MyThreadlist[i].getFlag()) {//δ����
        				returnNum++;
        			}
        		}
        	}
        	if(returnNum==0) {//�����߳�ȫ��������
        		if(borrowNum==0) {//�����߳�Ҳȫ��������
        			break;
        		}
        		else {//���н����߳�û�н����������Ǳ������޷����ѣ����仹���߳�ȷ�����򲻻ᱻ����
        			new Returnbook("���仹���߳�",book).start();
        		}
        	}
        }
	}
}
