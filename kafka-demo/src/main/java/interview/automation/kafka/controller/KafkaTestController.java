package interview.automation.kafka.controller;

import interview.automation.kafka.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Start Zookeeper server(2181):
 *    zkserver
 * Start Kafka server(9092):
 *    c:\DevEnv\kafka_2.13-2.5.0>.\bin\windows\kafka-server-start.bat .\config\server.properties
 * Create a Kafka topic:
 *    bin/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test_topic
 * Purge a kafka topic elements:
 *    c:\DevEnv\kafka_2.13-2.5.0\bin\windows>kafka-topics.bat --zookeeper localhost:2181 --alter --topic test_topic
 *
 */
@RestController
@RequestMapping("/api/kafka")
public class KafkaTestController {
    Logger logger = LoggerFactory.getLogger(KafkaTestController.class);
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @GetMapping("/send")
    public String sendString(@RequestParam("topic") String topic, @RequestParam("message") String message){
        kafkaTemplate.send(topic, message);
        return "\"" + message +"\" send successfully!";
    }

    /**
     * http://localhost:9000/api/kafka/senduser?topic=test_topic
     * body:
         * {
         * 	"id": 1,
         * 	"firstName": "David",
         * 	"lastName": "Smith",
         * 	"address":{
         * 		"street1": "2839 ladcid street",
         * 		"street2": "Markham",
         * 		"city": "Toronto",
         * 		"province": "ON",
         * 		"country": "Canada",
         * 		"postCode": "A1A 3D3"
         *        }
         * }
     * @param user
     * @param topic
     * @return
     */
    @PostMapping("/senduser")
    public UserInfo sendUser(@RequestBody UserInfo user, @RequestParam("topic") String topic){
        kafkaTemplate.send(topic, user);
        return user;
    }
    @KafkaListener(topics="test_topic", groupId = "group_id")
    public void receiveString(String message){
        logger.info("Receive message \" "+message+"\"");
    }
   @KafkaListener(topics="test_topic", groupId = "group_id")
    public void receiveUser(UserInfo user){
        logger.info("Receive userinfo \" "+user+"\"");
    }
}
