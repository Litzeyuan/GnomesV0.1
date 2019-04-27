package gnomes.spring.gnomesv01.models;

public class LocationImpl {

    private long    locationId;
    private String  name;
    private String  address;
    private int     bedsAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedsAmount() {
        return bedsAmount;
    }

    public void setBedsAmount(int bedsAmount) {
        this.bedsAmount = bedsAmount;
    }
}
