package gnomes.spring.gnomesv01.models;


public class BedImpl extends BaseEntity implements Bed{

    private Long        bedId;
    private String      name;
    private int         length;
    private int         width;
    private String      compost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getCompost() {
        return compost;
    }

    public void setCompost(String compost) {
        this.compost = compost;
    }
}
