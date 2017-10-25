package si.petrol.workshop.market.integrations.mock;

import si.petrol.workshop.market.integrations.ProcessorClient;
import si.petrol.workshop.market.lib.enums.CreditCardType;
import si.petrol.workshop.market.lib.enums.TransactionStatus;
import si.petrol.workshop.market.models.db.PaymentMethodInfoEntity;
import si.petrol.workshop.market.models.db.TransactionEntity;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class ProcessorclientMock implements ProcessorClient {

    @Override
    public TransactionEntity executeTransaction(TransactionEntity transaction) {

        if (transaction.getAmount().compareTo(new BigDecimal("100")) > 0) {
            transaction.setStatus(TransactionStatus.DECLINED);
            transaction.setGatewayDeclineCode("INSUFFICENT_FOUNDS");


        } else {
            transaction.setStatus(TransactionStatus.SETTLED);
        }

        PaymentMethodInfoEntity pe = new PaymentMethodInfoEntity();
        pe.setCreditCardType(CreditCardType.MASTERCARD);

        transaction.setPaymentMethodInfo(pe);

        return transaction;
    }
}
