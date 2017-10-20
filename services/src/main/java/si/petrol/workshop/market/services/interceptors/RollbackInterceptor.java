package si.petrol.workshop.market.services.interceptors;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@RollBack
public class RollbackInterceptor {

    @PersistenceContext
    private EntityManager em;

    @AroundInvoke
    public Object rollBackOnException(InvocationContext ic) throws Exception {
        try {
            return ic.proceed();
        } catch (Exception e) {

            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

}
