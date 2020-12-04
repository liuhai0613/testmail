package com.study.testmail;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class TestmailApplicationTests {

    @Test
    boolean testDingDingRobot() throws ApiException {
        //每个机器人每分钟最多发送20条。
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=c5c8bd22cb63ccff3b4452867a95ced5dda73c1694efbb0f088bad8cd7bdde3e");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        //request.setHttpMethod("POST");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("监控平台: 测试文本消息!");
        request.setText(text);
        //OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        //选择@谁
        //at.setAtMobiles(Arrays.asList("1561126XXXX"));
        //@所有人
        //at.setIsAtAll(true);
        //request.setAt(at);
        OapiRobotSendResponse response = client.execute(request);
        return response.isSuccess();
    }
}
