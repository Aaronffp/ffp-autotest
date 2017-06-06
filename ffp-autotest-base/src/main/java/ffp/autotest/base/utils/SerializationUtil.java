/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平(263869564@qq.com) 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <strong>序列化工具类</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils SerializationUtil.java Exp $
 */
public class SerializationUtil {

    /**
     * <strong>序列化：将一个对象转换为二进制的数据流。
     * 如果一个类的对象要想实现序列化，就必须实现serializable接口。在此接口中没有任何的方法，
     * 此接口只是作为一个标识，表示本类的对象具备了序列化的能力而已。</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils SerializationUtil.java serialize Exp $
     * 
     * @param object 需要序列化的对象
     * @return 二进制流
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * <strong>反序列化:将二进制数据流转换成相应的对象。</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils SerializationUtil.java deserialize Exp $
     * 
     * @param bytes 序列化对象二进制
     * @return 对象
     */
    public static Object deserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
