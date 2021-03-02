package studentproject;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import studentService.Student;
import studentService.StudentService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration<StudentService> serviceRegistrationToExportStudentService;
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Student Service is start");
		StudentService studentService=new StudentService();
		serviceRegistrationToExportStudentService=context.registerService(StudentService.class, studentService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Student Service is end");
		serviceRegistrationToExportStudentService.unregister();
	}

}
