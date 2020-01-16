package highqualitycode.equal;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/07/16:17
 */
public class Captain extends Hero {
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Captain(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Captain) {
            Captain c = (Captain) obj;
            return super.equals(obj) && c.getId() == id;
        }
        return false;
    }
}
