package q.thread.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSend implements Runnable{
	private Socket socket;
	
	public ServerSend(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try(PrintWriter pw = new PrintWriter(socket.getOutputStream());
				Scanner sc = new Scanner(System.in);) {
			
			while(true) {
				String message = sc.nextLine();
				pw.println(message);
				pw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
