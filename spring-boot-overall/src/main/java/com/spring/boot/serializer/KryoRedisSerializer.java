package com.spring.boot.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayOutputStream;

/**
 * @ClassName KryoRedisSerializer
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/21 17:09
 * @Version 1.0
 */
public class KryoRedisSerializer<T> implements RedisSerializer<T> {



    Logger logger = LoggerFactory.getLogger(KryoRedisSerializer.class);

    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    private static final ThreadLocal<Kryo> kryos = ThreadLocal.withInitial(Kryo::new);

    private Class<T> clazz;

    public KryoRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return EMPTY_BYTE_ARRAY;
        }

        Kryo kryo = kryos.get();
        kryo.setReferences(false);
        kryo.register(clazz);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, t);
            output.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return EMPTY_BYTE_ARRAY;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }

        Kryo kryo = kryos.get();
        //todo 注意：setDefaultSerializer不能放在获取get之后，否则会有问题
        //kryo.setDefaultSerializer(FieldSerializer::new);
        //kryo.setDefaultSerializer(CompatibleFieldSerializer.class); //支持新增字段去接收历史数据
        kryo.setReferences(false);
        kryo.register(clazz);


        try (Input input = new Input(bytes)) {
            return (T) kryo.readClassAndObject(input);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    public static Kryo getKryo(){
        Kryo k = kryos.get();
        if(k == null){
            k = new Kryo();
            k.setDefaultSerializer(CompatibleFieldSerializer.class);
            kryos.set(k);
        }
        return k;
    }

}
