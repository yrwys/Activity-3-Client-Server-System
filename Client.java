import java.net.*;  
import java.io.*;  

public class Client{  
	
	public static void main(String args[])throws Exception{  
		
		Socket s = new Socket("localhost", 8888);  
		DataInputStream dis = new DataInputStream(s.getInputStream());  
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		
		String str1 = "";
		String str2 = "";  
		
		System.out.println("CLIENT");
		
		while(!str1.equals("bye")){  
			System.out.print("Enter message: ");
			str1 = br.readLine();  
			dos.writeUTF(str1);  
			dos.flush();  
			str2 = dis.readUTF();  
			System.out.println("Server: "+str2);  
			}
		
		dos.close();  
		s.close();  
		
		}
	}  

