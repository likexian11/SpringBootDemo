package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.example.demo.config.BasicConfig;

public class VerifySign {

    /**
     * 验证签名
     * @param content 签证签名内容串
     * @param sign 签名
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名类型
     * @return
     * @throws RsaSignException
     */
    public static boolean rsaCheck(String content, String sign, String publicKey, String charset, String signType) throws Exception {
        if ("RSA".equals(signType)) {
            return rsaCheckContent(content, sign, publicKey, charset);
        } else if ("RSA2".equals(signType)) {
            return rsa256CheckContent(content, sign, publicKey, charset);
        } else {
            throw new Exception("Sign Type is Not Support : signType=" + signType);
        }
    }

    public static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        StringWriter writer = new StringWriter();
        StreamUtil.io(new InputStreamReader(ins), writer);
        byte[] encodedKey = writer.toString().getBytes();
        encodedKey = Base64.decodeBase64(encodedKey);
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }

    public static boolean rsaCheckContent(String content, String sign, String publicKey, String charset) throws Exception {
        try {
            PublicKey e = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(e);
            if (EmptyUtil.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception var6) {
            throw new Exception("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, var6);
        }
    }

    public static boolean rsa256CheckContent(String content, String sign, String publicKey, String charset) throws Exception {
        try {
            PublicKey e = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(e);
            if (EmptyUtil.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception var6) {
            throw new Exception("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, var6);
        }
    }
    
	public static void main(String[] args) {
		String content = "amount=1&app=h50008530000066&local_order_no=10F92A0D077E43D7A503A29847F101C0_100&operator_id=c777292c6becd2d7fd3f7d898e847d04&subject=测试缴费人员2|住宿费|计算机1901班|0.01|201910002&timestamp=1560849225000&key=fc471d2a8ec3670f7789e0dfcbb8dfb1";
		String sign = "GJq7u3GhZtVR6lSwhu3NBH7Mqh5k3bCd5MdFlMBd7WA2Bfbiz2PBdhGqIaWWRS+m8/UGHC9aHUkvEYqkdEwlD3EmJZQ5SgVfZOS75FqvVkfxQ0fIYXvxrJATjcIIAruZ0dIZuaHpPLa5yPLFLUck05WiK+DDL4HQT2JPVA8Stbmd/kChk0cNbOSzbeLZxYW7hVUvhSZnz7RNRqDikMMCfvcWV7j8q2c6cG0LxvNo8orMnDov0CrqyxYE5FjrusXS/nKTopm8xtzj1N1vnde5KJNZM9v6AHDS1jLua75xLicr9BVAqCVJ9pHrMDI62beeAQelR3CTVwctiG1Ufz8fhg==";
		try {
			System.out.println(rsaCheck(content, sign, BasicConfig.PUBLIC_KEY, "UTF-8", "RSA2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
