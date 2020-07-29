package interview.automation.jms;

import interview.automation.jms.component.MessageReceiver;
import interview.automation.jms.model.UserInfo;
import interview.automation.jms.utils.CommonUtil;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class JmsDemoApplication {
	@Autowired
	private JmsTemplate jmsTemplate;
	public static void main(String[] args) {
		SpringApplication.run(JmsDemoApplication.class, args);
	}

	@Bean
	public void produceUsersToQueue(){
		UserInfo.Address address = new UserInfo.Address("street1","street2","Markham","ON","Canada","B2R 4I2");
		UserInfo user1 = new UserInfo(1L,"David","Lanthen",address);
		jmsTemplate.convertAndSend(CommonUtil.MSG_QUEUE,user1);

	}

}
