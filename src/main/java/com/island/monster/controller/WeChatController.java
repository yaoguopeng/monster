package com.island.monster.controller;


import com.island.monster.common.Response;
import com.island.monster.common.WeChatBean;
import com.island.monster.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/island/")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    /**
     *
     * 通过解码获取用户信息的json对象，授权后调用
     *
     * @param weChatBean
     * @return
     */
    @RequestMapping(value="decode",method= RequestMethod.POST)
    public Response<String> decode(@RequestBody WeChatBean weChatBean){
        String result = weChatService.decode(weChatBean);
        if(result == null ){
            Response.failed("解码异常！",1);
        }
        if("disableCode".equals(result)){
            Response.failed("code已失效，无法解码！",2);
        }
        if("withoutSessionKey".equals(result)){
            Response.failed("sessionKey 为空，无法解码！",3);
        }
        return Response.success(result);
    }
}
