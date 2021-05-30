import java.net.*;
import java.io.*;
import java.util.*;

class Client
{
public static void main(String[] args) 
{
try
{
 String pname=args[0];
 int pno=Integer.parseInt(args[1]);
 Socket s=new Socket(pname,pno);
 System.out.println("client obtained connection from server");
 System.out.println("Enter a number ");
 Scanner sn=new Scanner(System.in);
 int data=sn.nextInt();
 OutputStream os=s.getOutputStream();
 DataOutputStream dos=new DataOutputStream(os);
 dos.writeInt(data);
 InputStream is=s.getInputStream();
 DataInputStream dis=new DataInputStream(is);
 int res=dis.readInt();
 System.out.println("Result from server : "+res);
}
catch (Exception e)
{
System.out.println(e);
}
}
}
