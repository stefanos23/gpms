/*
 * LocalInfo.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 
 * LocalInfo class provides the mac and ip information of the user's device.
 * LocalInfo is used for obtaining register information for our system.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * 
 */

public class LocalInfo {

	/**
	 * This method searchs for the user's ip and mac address and return the mac.
	 * 
	 * @return the mac address of the user's network interface
	 */
	public String getMacAddressFromIp() {

		InetAddress ip;
		try {

			// gets ip address
			ip = InetAddress.getLocalHost();
			// get all network interfaces
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			// gets mac address
			byte[] mac = network.getHardwareAddress();
			// converting the obtained mac address to string
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				stringBuilder.append(String.format("%02X%s", mac[i],
						(i < mac.length - 1) ? "-" : ""));
			}

			return stringBuilder.toString();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (SocketException e) {

			e.printStackTrace();

		}
		return null;
	}
}
