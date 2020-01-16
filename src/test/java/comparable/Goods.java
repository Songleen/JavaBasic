package comparable;

/**
 * 商品类
 *
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/31/13:56
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //自定义类中的重写
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods = (Goods)o;
            //写法一：
            /*if (this.price>goods.price){
                return 1;
            }else if (this.price<goods.price){
                return -1;
            }else {
                return 0;
            }*/
            //写法二
            return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("输入的对象不正确");
    }
}
