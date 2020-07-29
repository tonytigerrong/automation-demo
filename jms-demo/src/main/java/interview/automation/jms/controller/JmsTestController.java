package interview.automation.jms.controller;

import interview.automation.jms.model.UserInfo;
import interview.automation.jms.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jms")
public class JmsTestController {

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/sendstring")
    public String sendString(@RequestParam("message") String message){
        jmsTemplate.convertAndSend(CommonUtil.MSG_QUEUE,message);
        return "Send \""+message+"\" successfully!";
    }

    @PostMapping("/senduser")
    public UserInfo sendUserInfo(@RequestBody UserInfo user){
        jmsTemplate.convertAndSend(CommonUtil.MSG_QUEUE,user);
        return user;
    }
}
