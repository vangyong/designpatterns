package cn.segema.learn.util;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class GuidUtil {

    public static String guid() {
        UUID u = UUID.randomUUID();
        byte[] b =
            ByteBuffer.allocate(16).putLong(u.getMostSignificantBits()).putLong(u.getLeastSignificantBits()).array();
        String guid = Base64.getUrlEncoder().withoutPadding().encodeToString(b);
        return guid;
    }

    public static UUID guid2uuid(String id) {
        UUID uuid = UUID.nameUUIDFromBytes(Base64.getUrlDecoder().decode((id + "==").getBytes()));
        return uuid;
    }

    public static void main(String[] args) {
        String guid = guid();
        System.out.println(guid);
        UUID uuid = guid2uuid(guid);
        System.out.println(uuid);
    }
}
