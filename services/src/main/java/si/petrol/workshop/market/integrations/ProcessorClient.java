package si.petrol.workshop.market.integrations;

import si.petrol.workshop.market.models.db.TransactionEntity;

public interface ProcessorClient {

    TransactionEntity executeTransaction(TransactionEntity trasnsaction);


}
