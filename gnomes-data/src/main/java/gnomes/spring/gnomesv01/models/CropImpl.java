package gnomes.spring.gnomesv01.models;

import java.time.LocalDate;

public class CropImpl implements Crop {

    // might not need all those details
    // do we need a crop name ?
    private long    cropId;
    private String  location;//?
    private	int     bedId;//?
    private String  family;//
    private	String  variety;
    private	int     quantity;
    private	String  sowingType;     // seed or module or direct
    private	String  rowSpacing;     // cm - number or seed or module
    private	int     plantSpacing;   // cm
    private	String  trayUsed;       // a number or direct
    private	String  sowingPerCell;	// a number or seed or direct
    private	String  composUsed;
    private	String  seedVender;
    private LocalDate seedBoughtDate;
    private LocalDate seedExpiration;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSowingType() {
        return sowingType;
    }

    public void setSowingType(String sowingType) {
        this.sowingType = sowingType;
    }

    public String getRowSpacing() {
        return rowSpacing;
    }

    public void setRowSpacing(String rowSpacing) {
        this.rowSpacing = rowSpacing;
    }

    public int getPlantSpacing() {
        return plantSpacing;
    }

    public void setPlantSpacing(int plantSpacing) {
        this.plantSpacing = plantSpacing;
    }

    public String getTrayUsed() {
        return trayUsed;
    }

    public void setTrayUsed(String trayUsed) {
        this.trayUsed = trayUsed;
    }

    public String getSowingPerCell() {
        return sowingPerCell;
    }

    public void setSowingPerCell(String sowingPerCell) {
        this.sowingPerCell = sowingPerCell;
    }

    public String getComposUsed() {
        return composUsed;
    }

    public void setComposUsed(String composUsed) {
        this.composUsed = composUsed;
    }

    public String getSeedVender() {
        return seedVender;
    }

    public void setSeedVender(String seedVender) {
        this.seedVender = seedVender;
    }

    public LocalDate getSeedBoughtDate() {
        return seedBoughtDate;
    }

    public void setSeedBoughtDate(LocalDate seedBoughtDate) {
        this.seedBoughtDate = seedBoughtDate;
    }

    public LocalDate getSeedExpiration() {
        return seedExpiration;
    }

    public void setSeedExpiration(LocalDate seedExpiration) {
        this.seedExpiration = seedExpiration;
    }
}
