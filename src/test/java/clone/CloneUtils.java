package clone;

import java.io.*;

/**
 * 使用字节流进行深拷贝的代码
 *
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/07/14:40
 */
public class CloneUtils {
    //拷贝一个对象
    public static <T extends Serializable> T clone(T obj){
        //拷贝产生的对象
        T clonedObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            //分配内存空间，写入原始对象，生成新对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (T) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clonedObj;
    }
}
