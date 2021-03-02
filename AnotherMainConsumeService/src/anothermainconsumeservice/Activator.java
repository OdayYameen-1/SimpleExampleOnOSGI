package anothermainconsumeservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import studentService.StudentService;
import userproject.ServiceFactory;
import userproject.userService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference userProjectToImportReference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.err.println("to show it use same objct");
		userProjectToImportReference = context.getServiceReference(StudentService.class.getName());
		StudentService studentService = (StudentService) context.getService(userProjectToImportReference);
		System.err.println("Same====>>>>studentService id "+studentService.hashCode());
		studentService.printStudents();
		System.err.println("//////////////////////////////////////////////////////////////////");
		userProjectToImportReference=context.getServiceReference(ServiceFactory.class);
		ServiceFactory sf=(ServiceFactory)context.getService(userProjectToImportReference);
		userService us=	sf.getService();
		System.out.println("Diff====>>>>user service id "+us.hashCode());
		us.printUsers();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		context.ungetService(userProjectToImportReference);
	}

}
