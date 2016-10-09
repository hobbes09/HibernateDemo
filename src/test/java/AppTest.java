import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.models.Employee;;

public class AppTest extends TestCase {

	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employee emp = new Employee("MrRogers");
		session.save(emp);

		session.getTransaction().commit();
		session.close();
	}
}
