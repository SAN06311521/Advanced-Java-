import java.net.*;
import java.io.*;

class Server
{
public static void main(String[] args) 
{	
try
{
int pno=Integer.parseInt(args[0]);
ServerSocket ss=new ServerSocket(pno);
System.out.println("server is ready to accept client request");
Socket s1=ss.accept();
InputStream is=s1.getInputStream();
DataInputStream dis=new DataInputStream(is);
int n=dis.readInt();
System.out.println("Value from client : "+n);
int res=n*n;
OutputStream os=s1.getOutputStream();
DataOutputStream dos=new DataOutputStream(os);
dos.writeInt(res);
s1.close();
}
catch (Exception e)
{
System.out.println(e);
}
}
}
