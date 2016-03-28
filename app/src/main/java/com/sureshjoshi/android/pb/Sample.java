// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: Sample.proto at 7:1
package com.sureshjoshi.android.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class Sample extends Message<Sample, Sample.Builder> {
  public static final ProtoAdapter<Sample> ADAPTER = new ProtoAdapter_Sample();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_X = 0;

  public static final Integer DEFAULT_Y = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#UINT32"
  )
  public final Integer x;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#UINT32"
  )
  public final Integer y;

  public Sample(Integer x, Integer y) {
    this(x, y, ByteString.EMPTY);
  }

  public Sample(Integer x, Integer y, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.x = x;
    this.y = y;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.x = x;
    builder.y = y;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Sample)) return false;
    Sample o = (Sample) other;
    return Internal.equals(unknownFields(), o.unknownFields())
        && Internal.equals(x, o.x)
        && Internal.equals(y, o.y);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (x != null ? x.hashCode() : 0);
      result = result * 37 + (y != null ? y.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (x != null) builder.append(", x=").append(x);
    if (y != null) builder.append(", y=").append(y);
    return builder.replace(0, 2, "Sample{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Sample, Builder> {
    public Integer x;

    public Integer y;

    public Builder() {
    }

    public Builder x(Integer x) {
      this.x = x;
      return this;
    }

    public Builder y(Integer y) {
      this.y = y;
      return this;
    }

    @Override
    public Sample build() {
      return new Sample(x, y, buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Sample extends ProtoAdapter<Sample> {
    ProtoAdapter_Sample() {
      super(FieldEncoding.LENGTH_DELIMITED, Sample.class);
    }

    @Override
    public int encodedSize(Sample value) {
      return (value.x != null ? ProtoAdapter.UINT32.encodedSizeWithTag(1, value.x) : 0)
          + (value.y != null ? ProtoAdapter.UINT32.encodedSizeWithTag(2, value.y) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Sample value) throws IOException {
      if (value.x != null) ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.x);
      if (value.y != null) ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.y);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Sample decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.x(ProtoAdapter.UINT32.decode(reader)); break;
          case 2: builder.y(ProtoAdapter.UINT32.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public Sample redact(Sample value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}