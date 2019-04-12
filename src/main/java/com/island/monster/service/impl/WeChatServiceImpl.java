package com.island.monster.service.impl;

import com.island.monster.common.DecodeUtil;
import com.island.monster.common.WeChatBean;
import com.island.monster.service.WeChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WeChatServiceImpl implements WeChatService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatServiceImpl.class);

    @Override
    public String decode(WeChatBean weChatBean) {
        String sessionKey = DecodeUtil.getSessionKey(weChatBean.getAppid(), weChatBean.getSecret(), weChatBean.getCode());
        String result = null;
        if (sessionKey == null) {
            LOGGER.info("sessionKey is null ");
            return "withoutSessionKey";
        } else if ("1".equals(sessionKey)) {
            LOGGER.info("code已失效");
            return "disableCode";
        } else {
            //解码
            try {
                result = DecodeUtil.decoderBase64(weChatBean.getEncryptedData(), sessionKey, weChatBean.getIv());
                LOGGER.info("解码成功！>>result=" + result);
            } catch (Exception e) {
                LOGGER.info("解码失败！>> 解码异常>> " + e);
                return null;
            }
        }
        return result;
    }
}
