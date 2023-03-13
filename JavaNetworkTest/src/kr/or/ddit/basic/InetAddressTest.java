package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 >> IP주소를 다루기 위한 클래스

		// www.naver.com
		InetAddress ip = InetAddress.getByName("www.naver.com");

		System.out.println(ip.getHostName());
		System.out.println(ip.getHostAddress());
		System.out.println(ip.toString());
		System.out.println();

		InetAddress localIP = InetAddress.getLocalHost();
		System.out.println("HostName" + localIP.getHostName());
		System.out.println("HostName" + localIP.getHostAddress());
		System.out.println();

		InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
		for (InetAddress i : ipArr) {
			System.out.println(i.toString());
		}

	}
}
