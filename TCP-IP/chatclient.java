import java.net.*;  
import java.io.*;  
class chatclient
{  
public static void main(String args[])throws Exception
{  
Socket s=new Socket("localhost",8566);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="";  
while(!str.equals("end"))
{  
str=br.readLine();  
dout.writeUTF(str);  
dout.flush();  
str2=din.readUTF();  
System.out.println("Server says: "+str2);  
}  
  
dout.close();  
s.close();  
}} 