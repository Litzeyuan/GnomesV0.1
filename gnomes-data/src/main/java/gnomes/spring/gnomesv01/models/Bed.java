package gnomes.spring.gnomesv01.models;


public class Bed extends BaseEntity{

    private Long        id;
    private String      name;
    private int         length;
    private int         width;
    private String      compost;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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