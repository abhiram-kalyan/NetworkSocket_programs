import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 


public class Server 
{ 
	public static void main(String[] args) throws IOException 
	{ 
 		System.out.println("The Server is running");
		ServerSocket ss = new ServerSocket(6520); 
		Scanner sc=new Scanner(System.in);
	
		while (true) 
		{ 
			Socket s = null; 
			
			try
			{ 
				s = ss.accept(); 

				System.out.println("Enter the name of Client ");
				String name=sc.nextLine();
				System.out.println(name+" is connected : " + s); 
				
				
				DataInputStream din = new DataInputStream(s.getInputStream()); 
				DataOutputStream dout = new DataOutputStream(s.getOutputStream()); 
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("Assigning new thread for this client"); 

			
				Thread t = new ClientHandler(s, din, dout,br,name); 

		
				t.start(); 
				
			} 
			catch (Exception e){ 
				s.close(); 
				e.printStackTrace(); 
			} 
		} 
	} 
} 


class ClientHandler extends Thread 
{ 
	
	final DataInputStream din; 
	final DataOutputStream dout; 
	final BufferedReader br;
	final Socket s; 
	String name;
	


	public ClientHandler(Socket s, DataInputStream din, DataOutputStream dout,BufferedReader br,String name) 
	{ 
		this.s = s; 
		this.din = din; 
		this.dout = dout; 
		this.br=br;
		this.name=name;
	} 

	@Override
	public void run() 
	{ 
		 
		
				try {   
					String str="",str2="";  
					while(!str.equals("end"))
					{  
					str=din.readUTF();  
					System.out.println(name+" says: "+str);
					if(str.equals("Exit")) 
					{ 
					System.out.println(name + " sends exit..."); 
					System.out.println("Closing this connection."); 
					this.s.close(); 
					System.out.println("Connection closed"); 
					 
					} 
					else{
					str2=br.readLine();  
					dout.writeUTF(str2);  
					dout.flush();
					}  
					}  
				
				
				
			}	
			catch (IOException e) { 
				e.printStackTrace(); 
			} 
		
		
		try
		{ 
			
			this.din.close(); 
			this.dout.close(); 
			
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	} 
} 
