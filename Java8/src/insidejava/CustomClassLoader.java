package insidejava;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileLock;

/**
 * @author gutenlee
 * @since 2022/11/01
 */
public class CustomClassLoader extends ClassLoader {

    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    private Class<?> getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";

        System.out.println();
        System.out.println("name = " + name);
        System.out.println("file = " + file);

        byte[] byteArr = null;
        try {
            byteArr = loadClassFileData(file); // xx.class 파일로부터 파이트 코드를 읽는다.

            // byte array -> Class
            Class<?> c = defineClass(name, byteArr, 0, byteArr.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] loadClassFileData(String name) throws IOException{
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte[] buff = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();

        return buff;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        if (name.startsWith("insidejava")) {
            clazz = getClass(name);
        } else {
            clazz = super.loadClass(name);
        }
        System.out.println("Loading class using : " + clazz.getClassLoader() + " name: " + name);
        return clazz;
    }
}
