package server;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
public class Server {//��������
	public static String changeCalendar() {//��ʱ����и�ʽ��
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		return year+"-"+month+"-"+day+"."+hour+":"+minute+":"+second;
	}
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1);//�����˿ں�Ϊ1�Ŀͻ�������
			System.out.println("�������Ѿ�����");
			while(true) {
				Socket s = server.accept();//���ܿͻ�������
				String clientIP=s.getInetAddress().toString();//��¼���Ϸ������Ŀͻ���IP
				int clientPort=s.getLocalPort();//��¼���Ϸ������Ŀͻ��˶˿�
				System.out.println("�ͻ���(IP:"+clientIP+",�˿�:"+clientPort+")�������˷�����");
				DataInputStream reader = new DataInputStream(s.getInputStream());
				try {
					FileWriter file = new FileWriter("Server.txt",true);//���û��,���½�Server.txt,ÿ�ζ������ļ�ĩβ�������
					String END = "end";//������Ϣ�������ı�־
					StringBuffer string = new StringBuffer();//string��¼�ͻ��˷��͵��ı���Ϣ
					while(true) {
						String str = reader.readUTF();//��str��¼һ�μ�¼
						if(str.equals(END)) {//������־���ᱻ��ӵ�string��
							break;
						}
						string.append(str+"\r\n");//��ÿ�μ�¼��ӵ�stringĩβ,���з�����
					}//��ȡ�ͻ��˷������ı���Ϣ��������string��,ÿ����¼֮���û��з�����
					file.write("ʱ��:"+changeCalendar()+",IP:"+clientIP+",�˿�:"+clientPort+",��Ϣ:"+"\r\n"+string);
					reader.close();
					file.close();
					s.close();
				}catch(FileNotFoundException e) {
					System.out.println("server.txt������!");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
