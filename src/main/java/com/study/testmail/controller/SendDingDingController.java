package com.study.testmail.controller;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendDingDingController {
//    @RequestMapping("/testDing")
//    public void testDing() throws ApiException {
//        boolean b = testDingDingRobot();
//        System.out.println(b);
//    }

    public static boolean testDingDingRobot(String content) throws ApiException {
        //每个机器人每分钟最多发送20条。
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=c5c8bd22cb63ccff3b4452867a95ced5dda73c1694efbb0f088bad8cd7bdde3e");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        request.setText(text);
        //OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        //at.setAtMobiles(Arrays.asList("1561126XXXX"));
        //at.setIsAtAll(true);
        //request.setAt(at);
        OapiRobotSendResponse response = client.execute(request);
        return response.isSuccess();
    }
}
