package com.island.monster.common;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;
import java.util.HashMap;

/**
 * 微信数据解码工具类
 */
public class WeChatDecodeUtil {


    /**
     * 只在第一次调用decrypt()方法时才new 对象
     * 保证解密算法包，有且只有一个提供者，避免jdk内置不支持报错
     */
    private static boolean initialized = false;


    public static String decoderBase64(String contant, String key, String iv) throws Exception {
        byte[] ivMing = Base64.getDecoder().decode(iv.getBytes("UTF-8"));
        byte[] sessionKeyMing = Base64.getDecoder().decode(key.getBytes("UTF-8"));
        byte[] encryptedDataMing = Base64.getDecoder().decode(contant.getBytes("UTF-8"));
        byte[] decoder = decoder(encryptedDataMing, sessionKeyMing, ivMing);
        return new String(decoder, "UTF-8");
    }

    /**
     * BouncyCastle作为安全提供，防止我们加密解密时候因为jdk内置的不支持改模式运行报错。
     * BouncyCastle表示解密使用的密码包提供者，
     */
    private static void initialize() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }


    /**
     * 解密数据
     *
     * @param contant
     * @param key
     * @param vi
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws InvalidParameterSpecException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private static byte[] decoder(byte[] contant, byte[] key, byte[] vi) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidParameterSpecException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        initialize();
        //根据解密 算法/模式/填充 获得一个对象
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        //初始化解密类
        //1.加载密码参数，构造方法传入算法名称
        AlgorithmParameters parameter = AlgorithmParameters.getInstance("AES");
        //2.初始化参数,参数为 加密参数的规范（IvParameterSpec为参数偏移量）
        parameter.init(new IvParameterSpec(vi));
        //3. 获得密钥  数据+算法名
        Key key1 = new SecretKeySpec(key, "AES");
        //初始化解密类
        cipher.init(Cipher.DECRYPT_MODE, key1, parameter);
        //使用类解密数据
        byte[] bytes = cipher.doFinal(contant);
        System.out.println(new String(bytes));
        return bytes;

    }

    public static String getSessionKey(String appid, String secret, String code) {
        String uri = "https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        HttpGet get = new HttpGet(uri);
        CloseableHttpClient httpClient = null;
        try {
            SSLContext sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(null, new TrustStrategy() {
                        // 信任所有
                        public boolean isTrusted(X509Certificate[] chain,
                                                 String authType)
                                throws CertificateException {
                            return true;
                        }
                    }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslContext);
            httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
                    .build();
            CloseableHttpResponse response = httpClient.execute(get);

            HttpEntity entity = response.getEntity();

            System.out.println(response.getStatusLine().getStatusCode());
            String s = EntityUtils.toString(entity, Consts.UTF_8);
            HashMap jsonToBean = JSON.parseObject(s, HashMap.class);

            Object sessionKey = jsonToBean.get("session_key");
            if (sessionKey != null) {
                return sessionKey.toString();
            } else {
                System.out.println(jsonToBean.get("errcode"));
                System.out.println(jsonToBean.get("errmsg"));
                return "1";
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
