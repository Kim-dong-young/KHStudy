package q.thread.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive extends Thread{
	private Socket socket;

	public ClientReceive(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
			while(true) {
				String message = br.readLine();
				System.out.println("서버로부터 받은 메세지 : " + message);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}