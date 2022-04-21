import java.net.*;  
import java.io.*;  

public class Server{  
	
	public static void main(String args[])throws Exception{  
		
		ServerSocket ss = new ServerSocket(8888);  
		Socket s = ss.accept();  
		DataInputStream dis = new DataInputStream(s.getInputStream());  
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		
		String str1 = "";
		String str2 = "";  
		
		System.out.println("SERVER");
		
		while(!str1.equals("bye")){
			str1 = dis.readUTF();  
			System.out.println("Client: "+str1);
			System.out.print("Enter message: ");
			str2 = br.readLine();
			dos.writeUTF(str2);  
			dos.flush();
			}  
		
		dis.close();  
		s.close();  
		ss.close();  
		
		}
	}  