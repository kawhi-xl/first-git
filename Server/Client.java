package client;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.net.Socket;
public class Client {//�ͻ���
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1);//ͨ��1�˿����������������
			DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());//��ȡ������Ϣ������
			Scanner input = new Scanner(System.in);
			String END = "end";//����̨��������ı�־
			System.out.println("����������������͵�����,���һ����"+END+"��ʾ�������");
			while(true) {
				String str = input.nextLine();//��str����¼��ǰ����̨�������һ����Ϣ
				dataOut.writeUTF(str);//��str��¼����Ϣ��ӵ�������Ϣ����
				if(str.equals(END)) {//�������
					break;
				}
			}
			input.close();//�ر�������
			dataOut.close();//�ر�����������
			s.close();//�ر��׽���
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
