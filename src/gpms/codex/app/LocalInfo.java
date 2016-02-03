package gpms.codex.app;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.Enumeration;

public class LocalInfo {

	public static void main(String[] args){
		
		
//		getLocalIPAddress();
//		
//		System.out.println("Mac address is: " + getMacAddress());
//		//NetworkInterface asd = new NetworkInterface();
//		
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
//		try {
//			getHostIpAddress();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
		getMacAddressFromIp();
	}
	
	
	private static String getLocalIPAddress(){
		
		String IP = null;
		
		 String ip;
		    try {
		        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		        while (interfaces.hasMoreElements()) {
		            NetworkInterface iface = interfaces.nextElement();
		            // filters out 127.0.0.1 and inactive interfaces
		            if (iface.isLoopback() || !iface.isUp())
		                continue;
		         
		            
		            
		            Enumeration<InetAddress> addresses = iface.getInetAddresses();
		            while(addresses.hasMoreElements()) {
		                InetAddress addr = addresses.nextElement();
		                ip = addr.getHostAddress();
		                System.out.println(iface.getDisplayName() + " " + ip);
		            }
		        }
		    } catch (SocketException e) {
		        throw new RuntimeException(e);
		    }
		    
		return IP;
	}
	
	private static String getMacAddress(){
		   
		
		Enumeration<NetworkInterface> interfaces;
		StringBuilder sb = null;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            // filters out 127.0.0.1 and inactive interfaces
            if (iface.isLoopback() || !iface.isUp())
                continue;
		byte[] mac = iface.getHardwareAddress();
           
           
           sb = new StringBuilder();
           for (int i = 0; i < mac.length; i++) {
               sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
           }
           
           
           System.out.println(sb.toString());
           
           

        }

        return sb.toString();
        
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static void getHostIpAddress() throws IOException{
		
		
		
		// iterate over the network interfaces known to java
		Enumeration<NetworkInterface> interfaces;
	
			interfaces = NetworkInterface.getNetworkInterfaces();
		OUTER : for (NetworkInterface interface_ : Collections.list(interfaces)) {
		  // we shouldn't care about loopback addresses
		  if (interface_.isLoopback())
		    continue;

		  // if you don't expect the interface to be up you can skip this
		  // though it would question the usability of the rest of the code
		  if (!interface_.isUp())
		    continue;

		  // iterate over the addresses associated with the interface
		  Enumeration<InetAddress> addresses = interface_.getInetAddresses();
		  for (InetAddress address : Collections.list(addresses)) {
		    // look only for ipv4 addresses
		    if (address instanceof Inet6Address)
		      continue;

		    // use a timeout big enough for your needs
		    if (!address.isReachable(3000))
		      continue;

		    // java 7's try-with-resources statement, so that
		    // we close the socket immediately after use
		    try (SocketChannel socket = SocketChannel.open()) {
		      // again, use a big enough timeout
		      socket.socket().setSoTimeout(3000);

		      // bind the socket to your local interface
		      socket.bind(new InetSocketAddress(address, 8080));

		      // try to connect to *somewhere*
		      socket.connect(new InetSocketAddress("google.com", 80));
		    } catch (IOException ex) {
		      ex.printStackTrace();
		      continue;
		    }

		    System.out.format("ni: %s, ia: %s\n", interface_, address);

		    // stops at the first *working* solution
		    break OUTER;
		  }
		}
		
		
		
	}
	
	public static String getMacAddressFromIp(){
		
		InetAddress ip;
		try {
				
			ip = InetAddress.getLocalHost();
			//System.out.println("Current IP address : " + ip.getHostAddress() + "222" + ip);
			System.out.println("Current IP address : " + ip.getHostAddress());
			
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
				
			byte[] mac = network.getHardwareAddress();
				
			System.out.print("Current MAC address : ");
				
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			System.out.println(sb.toString());
			return sb.toString();
				
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		} catch (SocketException e){
				
			e.printStackTrace();
				
		}
		return null;
	}
}
