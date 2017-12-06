package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送端程序
 * 
 * @author JachinWei_wyg
 * @version 1.0 2017/12/06
 */
public class UDPSend {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(3000);
		String str = "hello world";
		// 指定要发送的数据包的内容, 包括数据,数据长度,接收端IP,和端口号
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 1717);
		System.out.println("发送信息中...");
		ds.send(dp);
		ds.close();
	}
}

package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端程序,必须慢于发送端启动
 * 
 * @author JachinWei_wyg
 * @version 1.0 2017/12/06
 */
public class UDPReceive {
	public static void main(String[] args) throws Exception{
		byte[] buf = new byte[1024]; //接收数据
		DatagramSocket ds = new DatagramSocket(1717); // 码头,监听端口
		DatagramPacket dp = new DatagramPacket(buf, 1024); // 集装箱,接收数据
		System.out.println("等待接收数据中...");
		ds.receive(dp); // 码头等待接收数据,没有数据会阻塞
		
		String str = new String(dp.getData(), 0, dp.getLength())
				+" from "+dp.getAddress().getHostAddress()+": "+dp.getPort();
		System.out.println(str);
		ds.close();
	}
}

