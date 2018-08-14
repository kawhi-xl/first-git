package client;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.net.Socket;
public class Client {//客户端
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1);//通过1端口向服务器发出请求
			DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());//获取网络信息流对象
			Scanner input = new Scanner(System.in);
			String END = "end";//控制台输入结束的标志
			System.out.println("请输入向服务器发送的内容,最后一行以"+END+"表示输入结束");
			while(true) {
				String str = input.nextLine();//用str来记录当前控制台输入的这一行信息
				dataOut.writeUTF(str);//将str记录的信息添加到网络信息流中,结束标志会传给服务器
				if(END.equals(str)) {//输入结束
					break;
				}
			}
			input.close();//关闭输入流
			dataOut.close();//关闭网络输入流
			s.close();//关闭套接字
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
