package p.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("보낼 메세지 : ");
		String message = sc.nextLine();
		
		InetAddress inet = null;
		int port = 4000;
		
		// 전송을 위한 데이터그램 소켓
		try (DatagramSocket dsoc = new DatagramSocket();){
			inet = InetAddress.getByName("192.168.30.2"); // 서버 측 주소 입력
			
			// 전송할 데이터 생성
			// socket은 지속성이 있다. 한번 소켓 만들때 연결 설정하고 거기로만 쭉 보냄
			// 패킷은 한번 만들고 보내면 끝. 계속 새로 만들어 준다
			// DatagramPacket(전송할 데이터의 Byte배열, 전송할 데이터의 길이, IP정보를 담은 InetAdress객체, 전송할 포트)
			DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length, inet, port);
			dsoc.send(dp);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
