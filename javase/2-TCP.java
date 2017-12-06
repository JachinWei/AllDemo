package demo;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 服务器端程序,必须先启动
 * 
 * @author JachinWei_wyg
 * @version 1.0 2017/12/06
 */
class TCPServer {
	public static void main(String[] args) throws Exception{
		new TCPServer().listen();
	}
	
	public void listen() throws Exception{
		ServerSocket ss = new ServerSocket(1718);
		Socket client = ss.accept();
		OutputStream os = client.getOutputStream();
		System.out.println("开始与客户端交互数据");
		os.write("hello world!".getBytes());
		Thread.sleep(5000);
		System.out.println("结束与客户端的交互数据");
		os.close();
		client.close();
	}
}


package demo;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端程序
 * 
 * @author JachinWei_wyg
 * @version 1.0 2017/12/06
 */
public class TCPClient {
	public static void main(String[] args) throws Exception{
		new TCPClient().connet();
	}
	
	public void connet() throws Exception{
		Socket client = new Socket(InetAddress.getLocalHost(), 1718);
		InputStream is = client.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		System.out.println(new String(buf, 0, len));
		client.close();
	}
}
