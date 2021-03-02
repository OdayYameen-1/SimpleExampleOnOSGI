package userproject;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import userproject.User;
import userproject.UserServiceInterface;
import userproject.userService;

public class UserProjectActivator implements BundleActivator {
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	ServiceRegistration UserProjectToExport;
	
	public void start(BundleContext bundleContext) throws Exception {
		 UserProjectActivator.context=bundleContext;
		 System.err.println("start exporting userproject");
		/*
		 *
		 *  userService us=new
		 * userService(); UserProjectToExport
		 * =context.registerService(userService.class, us, null);
		 */
		 /////////////add  service factory////////////////
		 ServiceFactory sf=new ServiceFactory();
		 UserProjectToExport =context.registerService(ServiceFactory.class,sf , null);
		 
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		UserProjectActivator.context=null;
		System.err.println("end exporting userproject");
		UserProjectToExport.unregister();
	}

}
