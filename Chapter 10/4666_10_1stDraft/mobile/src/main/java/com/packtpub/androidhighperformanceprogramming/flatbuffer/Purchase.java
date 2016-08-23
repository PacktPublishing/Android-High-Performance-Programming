package com.packtpub.androidhighperformanceprogramming.flatbuffer;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Purchase extends Table {
    public static Purchase getRootAsPurchase(ByteBuffer _bb) {
        return getRootAsPurchase(_bb, new Purchase());
    }

    public static Purchase getRootAsPurchase(ByteBuffer _bb, Purchase obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb));
    }

    public Purchase __init(int _i, ByteBuffer _bb) {
        bb_pos = _i;
        bb = _bb;
        return this;
    }

    public String id() {
        int o = __offset(4);
        return o != 0 ? __string(o + bb_pos) : null;
    }

    public ByteBuffer idAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public String name() {
        int o = __offset(6);
        return o != 0 ? __string(o + bb_pos) : null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public int quantity() {
        int o = __offset(8);
        return o != 0 ? bb.getInt(o + bb_pos) : 0;
    }

    public int price() {
        int o = __offset(10);
        return o != 0 ? bb.getInt(o + bb_pos) : 0;
    }

    public static int createPurchase(FlatBufferBuilder builder,
                                     int idOffset,
                                     int nameOffset,
                                     int quantity,
                                     int price) {
        builder.startObject(4);
        Purchase.addPrice(builder, price);
        Purchase.addQuantity(builder, quantity);
        Purchase.addName(builder, nameOffset);
        Purchase.addId(builder, idOffset);
        return Purchase.endPurchase(builder);
    }

    public static void startPurchase(FlatBufferBuilder builder) {
        builder.startObject(4);
    }

    public static void addId(FlatBufferBuilder builder, int idOffset) {
        builder.addOffset(0, idOffset, 0);
    }

    public static void addName(FlatBufferBuilder builder, int nameOffset) {
        builder.addOffset(1, nameOffset, 0);
    }

    public static void addQuantity(FlatBufferBuilder builder, int quantity) {
        builder.addInt(2, quantity, 0);
    }

    public static void addPrice(FlatBufferBuilder builder, int price) {
        builder.addInt(3, price, 0);
    }

    public static int endPurchase(FlatBufferBuilder builder) {
        int o = builder.endObject();
        return o;
    }
};

