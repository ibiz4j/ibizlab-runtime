//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.ibizlab.util.helper;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Security;
import java.util.Arrays;

public class Sm3Util {
    private static final Logger log = LoggerFactory.getLogger(Sm3Util.class);

    private Sm3Util() {
    }

    public static byte[] hash(byte[] data) {
        SM3Digest digest = new SM3Digest();
        digest.update(data, 0, data.length);
        byte[] hash = new byte[digest.getDigestSize()];
        digest.doFinal(hash, 0);
        return hash;
    }

    public static boolean verify(byte[] data, byte[] sm3Hash) {
        byte[] newHash = hash(data);
        return Arrays.equals(newHash, sm3Hash);
    }

    public static byte[] hmac(byte[] key, byte[] data) {
        KeyParameter keyParameter = new KeyParameter(key);
        SM3Digest digest = new SM3Digest();
        HMac mac = new HMac(digest);
        mac.init(keyParameter);
        mac.update(data, 0, data.length);
        byte[] result = new byte[mac.getMacSize()];
        mac.doFinal(result, 0);
        return result;
    }

    public static String encrypt(String paramStr) {
        String resultJexString = "";

        try {
            byte[] bytes = paramStr.getBytes();
            byte[] hash = hash(bytes);
            resultJexString = ByteUtils.toHexString(hash);
        } catch (Exception var4) {
            log.error(var4.getMessage());
        }

        return resultJexString;
    }

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Admin123").toUpperCase());
    }
}
