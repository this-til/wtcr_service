package com.til.wtcr_service.util;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ByteBufUtil {

    public static String readString(ByteBuf byteBuf, Charset charset) {
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byte b = byteBuf.readByte();
        int len = 0;
        while (b != '\0') {
            bytes[len++] = b;
            b = byteBuf.readByte();
        }
        return new String(bytes, 0, len, charset == null ? StandardCharsets.UTF_8 : charset);
    }

    public static void writeString(ByteBuf byteBuf, String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byteBuf.writeBytes(bytes);
        byteBuf.writeByte('\0');
    }
}
