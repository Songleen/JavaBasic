package reflection.practiceOne;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/11/02/20:35
 */
public class Header {
    private String headerName;
    private int headerAge;

    public Header() {
    }

    public Header(String headerName, int headerAge) {
        this.headerName = headerName;
        this.headerAge = headerAge;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public int getHeaderAge() {
        return headerAge;
    }

    public void setHeaderAge(int headerAge) {
        this.headerAge = headerAge;
    }
}
