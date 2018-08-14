package server;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class Server {//服务器端
	public static String changeCalendar() {//对时间格式进行格式化处理
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
		return format.format(cal.getTime());
	}
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1);//在1端口上监听客户端的连接请求
			System.out.println("服务器已经启动");
			while(true) {
				Socket s = server.accept();//接受客户端请求
				String clientIP=s.getInetAddress().toString();//记录连上服务器的客户端IP
				int clientPort=s.getLocalPort();//记录连上服务器的客户端端口
				System.out.println("客户端(IP:"+clientIP+",端口:"+clientPort+")连接上了服务器");
				DataInputStream reader = new DataInputStream(s.getInputStream());
				try {
					FileWriter file = new FileWriter("Server.txt",true);//如果没有,就新建Server.txt,每次都是向文件末尾添加内容
					String END = "end";//与客户端通信结束的标志
					StringBuffer string = new StringBuffer();//string记录客户端发送的文本信息
					while(true) {
						String str = reader.readUTF();//用str记录一次记录
						if(END.equals(str)) {//结束标志(不会被添加到string中)
							break;
						}
						string.append(str+"\r\n");//把每次记录添加到string末尾,换行符隔开
					}//获取客户端发来的文本信息，保存在string中,每个记录之间用换行符隔开
					file.write("时间:"+changeCalendar()+",IP:"+clientIP+",端口:"+clientPort+",信息:"+"\r\n"+string);
					file.close();
				}catch(FileNotFoundException e) {
					System.out.println("server.txt不存在!");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
