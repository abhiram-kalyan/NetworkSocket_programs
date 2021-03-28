import java.net.*;  
import java.util.*;
public class UDPServer
{  
  public static void main(String[] args) throws Exception 
  {  

    DatagramSocket ds = new DatagramSocket(); 
    System.out.println("The date server is running...");
    while(true)
    {
        String str = new Date().toString();
        InetAddress ip = InetAddress.getByName("192.168.0.8");  
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 2000);  
        ds.send(dp);  
    }
    
   
  }  
}  