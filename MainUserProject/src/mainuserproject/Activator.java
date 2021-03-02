package mainuserproject;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import studentService.StudentService;
import userproject.ServiceFactory;
import userproject.User;
import userproject.userService;

public class Activator implements BundleActivator {
	public static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	ServiceReference userProjectToImportReference;

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		User u = new User(100, "fvasdvf", "1221");
		System.out.println(u);
		System.err.println("Start importing studentservice");

		userProjectToImportReference = context.getServiceReference(StudentService.class.getName());
		StudentService studentService = (StudentService) context.getService(userProjectToImportReference);
		System.err.println("Same====>>>>studentService id "+studentService.hashCode());
		studentService.insertStudent();
		studentService.printStudents();
		System.err.println("//////////////////////////////////////////////////////////////////");

		
		
		userProjectToImportReference = context.getServiceReference(ServiceFactory.class);
		ServiceFactory sf = (ServiceFactory) context.getService(userProjectToImportReference);
		userService us=sf.getService();
		System.out.println("Diff====>>>>user service id "+us.getClass().hashCode());
		
		us.insertUSer();
		us.printUsers();

	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;

		System.err.println("end importing userproject");

		context.ungetService(userProjectToImportReference);
	}

}
