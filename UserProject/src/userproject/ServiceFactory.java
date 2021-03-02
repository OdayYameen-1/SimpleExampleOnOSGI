package userproject;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceRegistration;

public class ServiceFactory {
	private int usageCounter;
	
	public userService getService() {
		 System.out.println("Create object of userServie for " );
	        usageCounter++;
	        System.out.println("Number of bundles using service " + usageCounter);
	        userService us = new userService();
	        return us;
	}

	
	public void ungetService() {
		System.out.println("Release object of userServie for "  );
        usageCounter--;
        System.out.println("Number of bundles using service " + usageCounter);
		
	}




}
