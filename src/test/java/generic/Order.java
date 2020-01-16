package generic;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/25/10:15
 */
public class Order<T> {

    private String orderName;
    private int orderId;
    private T orderT;

    public Order() {
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public <E> void copy(E[] arr){
        List<E> list = Arrays.asList(arr);
        for (E e : list) {
            System.out.println(e);
        }
    }

}
