package networkTest;
import java.net.*;
public class BasicIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FOR SERVER:
		/**
		
		// open socket
		ServerSocket serverSocket = new ServerSocket(PORTNUM);
		
		//accept connections
		Socket socket = serverSocket.accept();
		**/
		
		//FOR CLIENT:
		/**
		
		Socket socket = new Socket(SERVER_ADDRESS, PORTNUM);
		 
		**/
		
		//BOTH IO
		/**
		
		//Open streams
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		//bufferedReader and PrintWriter can wrap input and output
		BufferedReader in = new BufferedReader(input);
		PrintWriter out = new PrintWriter(output);
		**/
	}

}
