package si.petrol.workshop.market.services.workers;

import com.rabbitmq.client.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class QueueWorker {

    //ponavadi ločeni od servica v svoj doker


    private Connection conn;
    private Channel channel;


    private void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("rabbit");
        factory.setPassword("rabbit");


        try {
            conn = factory.newConnection();
            channel = conn.createChannel();

            channel.queueDeclare("ordersCompletedQueue", true, false, false, null);

            Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    String orderId = new String(body, StandardCharsets.UTF_8);
                    System.out.println("**** orderId:" + orderId);

                }
            };

            channel.basicConsume("ordersCompletedQueue", true, consumer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

}
