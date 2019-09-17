package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class SerializeUtil {

	private final static Logger log = LoggerFactory.getLogger(SerializeUtil.class);

	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		byte[] bytes = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			bytes = baos.toByteArray();
			oos.flush();

			if (null != oos) {
				try {
					oos.close();
				} catch (IOException e) {
					log.error("序列化关闭io失败", e);
				}
			}
			if (null != baos)
				try {
					baos.close();
				} catch (IOException ex) {
					log.error("序列化关闭io失败", ex);
				}
		} catch (Exception e) {
			log.error("数据反序列化失败", e);

			if (null != oos) {
				try {
					oos.close();
				} catch (IOException ex) {
					log.error("序列化关闭io失败", e);
				}
			}
			if (null != baos)
				try {
					baos.close();
				} catch (IOException ex) {
					log.error("序列化关闭io失败", e);
				}
		} finally {
			if (null != oos) {
				try {
					oos.close();
				} catch (IOException e) {
					log.error("序列化关闭io失败", e);
				}
			}
			if (null != baos) {
				try {
					baos.close();
				} catch (IOException e) {
					log.error("序列化关闭io失败", e);
				}
			}
		}
		return bytes;
	}

	/**
	 * 反序列化对象
	 * @param bytes
	 * @return
	 */
	public static Object unserialize ( byte[] bytes ) {
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		Object object = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			object = ois.readObject();
			return object;
		} catch (Exception e) {
			log.error("数据反序列化失败", e);
		} finally {
			if (null != ois) {
				try {
					ois.close();
				} catch (IOException e) {
					log.error("序列化关闭io失败", e);
				}
			}

			if (null != bais) {
				try {
					bais.close();
				} catch (IOException e) {
					log.error("序列化关闭io失败", e);
				}
			}

		}
		return object;
	}

}