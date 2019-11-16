package ning.kafka.send;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by dongw on 2019/11/8.
 */

@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"dongwn"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("订阅dongwn消息----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
    }

}
