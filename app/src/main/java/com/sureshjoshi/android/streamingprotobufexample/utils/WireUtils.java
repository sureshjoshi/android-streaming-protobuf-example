package com.sureshjoshi.android.streamingprotobufexample.utils;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class WireUtils {

    public static void writeDelimitedTo(OutputStream outputStream, List<Message> messages) throws IOException {
        for (Message message : messages) {
            writeDelimitedTo(outputStream, message);
        }
    }

    public static void writeDelimitedTo(OutputStream outputStream, Message message) throws IOException {
        int size = message.adapter().encodedSize(message);
        BufferedSink sink = Okio.buffer(Okio.sink(outputStream));
        sink.writeIntLe(size);
        message.encode(sink);
        sink.emit();
    }

    public static <M extends Message> List<M> readDelimitedFrom(InputStream inputStream, ProtoAdapter<M> adapter) throws IOException {
        List<M> messages = new ArrayList<>();
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        while (!source.exhausted()) {
            int size = source.readIntLe();
            byte[] bytes = source.readByteArray(size);
            messages.add(adapter.decode(bytes)); // TODO: Reflect this or something
        }
        return messages;
    }
}
