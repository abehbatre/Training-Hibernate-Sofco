import org.hibernate.SessionFactory;
import presentation.MainMenu;
import utils.AppException;
import utils.HibernateUtilities;

/**
 * -------------------------------------------------------------------------------
 * MainClass
 * -------------------------------------------------------------------------------
 *
 * @author <AdityaPratama>
 * @version 0.1
 * @since April 2019
 * @project training_hibernate_tiga
 *
 * -------------------------------------------------------------------------------
 */

public class Main {
    /* init and call hibernate session factory on app start */
    private static SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();

    /* ~ call MainMenu ~ */
    public static void main(String[] args) throws AppException {
        new MainMenu();
    }
}
