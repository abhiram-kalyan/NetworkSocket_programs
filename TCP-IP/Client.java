import java.io.*; 
import java.net.*; 
import java.util.Scanner; 


public class Client 
{ 
    public static void main(String[] args) throws IOException 
    { 
        try
        { 
            Scanner scn = new Scanner(System.in); 

            InetAddress ip = InetAddress.getByName("localhost"); 

            Socket s = new Socket(ip, 6520); 

        
            DataInputStream din = new DataInputStream(s.getInputStream()); 
            DataOutputStream dout = new DataOutputStream(s.getOutputStream()); 
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
            

            scn.close(); 
            din.close(); 
            dout.close(); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
}