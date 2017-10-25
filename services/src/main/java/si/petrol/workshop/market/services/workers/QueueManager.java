package si.petrol.workshop.market.services.workers;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import si.petrol.workshop.market.models.db.OrderEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class QueueManager {

    private Connection conn;
    private Channel channel;

    @PostConstruct
    private void init() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("rabbit");
        factory.setPassword("rabbit");

        try {
            conn = factory.newConnection();
            channel = conn.createChannel();

            channel.queueDeclare("ordersCompletedQueue", true, false, false, null);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

    public void enqueueCompletedOrder(OrderEntity orderEnt) {

        try {
            channel.basicPublish("", "ordersCompletedQueue", null, orderEnt.getId().getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
