package si.petrol.workshop.market.api.servlets;

import org.apache.logging.log4j.core.appender.ConsoleAppender;
import si.petrol.workshop.market.lib.enums.CustomerStatus;
import si.petrol.workshop.market.models.db.AddressEntity;
import si.petrol.workshop.market.models.db.CurtomerEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aa")
public class SampleServlet extends HttpServlet {
    @Inject
    private DbBean dbBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("Jou man");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CurtomerEntity cust = new CurtomerEntity();
        cust.setFirstName("Borut");
        cust.setLastName("Komac");
        cust.setStatus(CustomerStatus.ACTIVE);
        AddressEntity adr = new AddressEntity();
        adr.setCity("Bovec");
        cust.setAddress(adr);

        dbBean.getEm().getTransaction().begin();

        dbBean.getEm().persist(cust);

        dbBean.getEm().getTransaction().commit();


        resp.getWriter().println(cust.getId());

    }
}
