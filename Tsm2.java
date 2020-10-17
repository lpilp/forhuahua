package test;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.engines.SM2Engine.Mode;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import org.zz.gmhelper.BCECUtil;
import org.zz.gmhelper.SM2Util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.util.Arrays;
// https://github.com/ZZMarquis/gmhelper  使用这个的封装的BC库函数
public class Tsm2 {
    public static void main(String[] args) {
        try {
            // 私钥
            String priHex = "58967e2beb6fffd3c96545eebd3000b39c10087d48faa0d41f9c7bf3720e0ea4";
            String xHex = "ec7e40b8dfa4b14383f703ec5403b71db0ab505b9fc41f0df45a9910a307dfbd";
            String yHex = "5b3c5afdd4b90d79fa0ab70d53fd88422df77e09b254a53e72b4857f74ab1da4";
            // 公钥
            // String pubKey = "04" + xHex + yHex;
            // 缺省的userId 就是： 1234567812345678， hex:就是 313233.....
            // byte[] withId = ByteUtils.fromHexString("31323334353637383132333435363738");

            ECPrivateKeyParameters priKey = new ECPrivateKeyParameters(
                new BigInteger(priHex,16), SM2Util.DOMAIN_PARAMS);
            ECPublicKeyParameters pubKey = BCECUtil.createECPublicKeyParameters(xHex, yHex, SM2Util.CURVE, SM2Util.DOMAIN_PARAMS);

            String string = "hello";
            byte[] bytes = string.getBytes();

            // 生成签名, 把这签名放到js里去验证
            byte[] sign = SM2Util.sign(priKey, null, bytes);

            System.out.println("the sign is: \n" + ByteUtils.toHexString(sign));
            System.out.println("============");


            System.out.println("====以下验证签名========");
            // 如果这里是没有asn1编码的，就是js里没有der参数的，就得再编码一次
            String  tSign= "3046022100f706f973a8d076be6c686f529130372c71b359ecdb92ccfc6134769b966ef84d022100f8b392fd6c1d82621a9e53a41225a51c59e24a402ca61a22004c4902ae686f39";
            // byte[] rawSign = hexStringToByteArray(dd);
            byte[] vSign = ByteUtils.fromHexString(tSign);

            // 如果给的签名是 304开头的是已asn1编码过的，就可以不用这一步了
            // vSign = SM2Util.encodeSM2SignToDER(vSign);

            boolean flag = SM2Util.verify(pubKey, null, bytes, vSign);
            System.out.println(flag); 
        } catch (Exception ex) {
            //TODO: handle exception
            ex.printStackTrace();

        }

        
        
    }
    public static void print_byte(byte[] bytes){
        for(int i=0; i<bytes.length;i++){
            System.out.print(bytes[i]+" ");
        }
        System.out.println();
    }
}
