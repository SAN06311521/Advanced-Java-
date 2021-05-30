import java.net.*;
	public class InetAddressEx {
		public static void main(String[] args) throws UnknownHostException {

		// returns the system details i.e. Inet Address
		InetAddress address = InetAddress.getLocalHost(); 

		System.out.println(address);
		
		// returns the address of the website
		address = InetAddress.getByName("www.facebook.com"); 
		
		System.out.println(address);

		//returns an array of IP addresses, based on the given host name and the configured name service on the system
		InetAddress ia[] = InetAddress.getAllByName("www.google.com");	
		for(int i=0; i< ia.length; i++) {
			System.out.println(ia[i]);
		}
	}
}