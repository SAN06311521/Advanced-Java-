import java.io.*;  
import java.net.*;  
	
public class MyServer {  
	public static void main(String[] args){  
		try{  
			ServerSocket ss=new ServerSocket(6666);  
			
			//establishes connection 
			//accept method beasically blocks the code, it will wait until client will not respond, the prog after accept will run only after the run of client
			Socket s=ss.accept();          

			DataInputStream dis=new DataInputStream(s.getInputStream());  
        		String  str=(String)dis.readUTF();  
			System.out.println("message= "+str);  
			ss.close();  
		}
		catch(Exception e){
			System.out.println(e);
		}  
	}  
}
