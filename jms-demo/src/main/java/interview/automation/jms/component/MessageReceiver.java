package interview.automation.jms.component;


import interview.automation.jms.model.UserInfo;
import interview.automation.jms.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class MessageReceiver {

    private Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
    @JmsListener(destination = CommonUtil.MSG_QUEUE,selector="_type='interview.automation.jms.model.UserInfo'")
    public void receiveUserInfo(UserInfo userInfo) throws JMSException {
        logger.info("Receive User {" + userInfo + "}");
    }

    @JmsListener(destination = CommonUtil.MSG_QUEUE,selector = "_type='java.lang.String'")
    public void receiveString(String message){
        logger.info("Receive Message {" + message + "}");
    }

}
