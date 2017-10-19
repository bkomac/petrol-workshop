package mappers;

import si.petrol.workshop.market.lib.PaymentMethodInfo;
import si.petrol.workshop.market.lib.Transaction;
import si.petrol.workshop.market.models.db.PaymentMethodInfoEntity;
import si.petrol.workshop.market.models.db.TransactionEntity;

public class TransactionMapper {

    public static Transaction toTransaction(TransactionEntity transactionEntity) {

        if (transactionEntity == null) return null;

        Transaction transaction = new Transaction();
        transaction.setId(transactionEntity.getId());
        transaction.setCreatedAt(transactionEntity.getCreatedAt());
        transaction.setUpdatedAt(transactionEntity.getUpdatedAt());
        transaction.setCurrency(transactionEntity.getCurrency());
        transaction.setAmount(transactionEntity.getAmount());
        transaction.setStatus(transactionEntity.getStatus());
        transaction.setGatewayDeclineCode(transactionEntity.getGatewayDeclineCode());
        transaction.setProcessorResponseCode(transactionEntity.getProcessorResponseCode());
        transaction.setProcessorResponseText(transactionEntity.getProcessorResponseText());
        transaction.setPaymentMethodType(transactionEntity.getPaymentMethodType());
        transaction.setPaymentMethodInfo(toPaymentMethodInfo(transactionEntity.getPaymentMethodInfo()));
        transaction.setGatewayTransactionId(transactionEntity.getGatewayTransactionId());

        transaction.setShippingAddress(AddressMapper.toAddress(transactionEntity.getShippingAddress()));
        transaction.setBillingAddress(AddressMapper.toAddress(transactionEntity.getBillingAddress()));

        return transaction;
    }

    private static PaymentMethodInfo toPaymentMethodInfo(PaymentMethodInfoEntity paymentMethodInfoEntity) {

        if (paymentMethodInfoEntity == null) return null;

        PaymentMethodInfo paymentMethodInfo = new PaymentMethodInfo();
        paymentMethodInfo.setCreditCardType(paymentMethodInfoEntity.getCreditCardType());

        return paymentMethodInfo;
    }
}
