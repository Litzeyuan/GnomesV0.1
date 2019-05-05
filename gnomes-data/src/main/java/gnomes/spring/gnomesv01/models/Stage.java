package gnomes.spring.gnomesv01.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "stages")
public class Stage extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean active;
    private LocalDate date;
    private	String AirTemp;
    private	String Humidity; // (%)
    private	String SoilTemp;
    private	String SoilMoisture; // (%)
    private	String LightLevel;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public Stage(){};
    public Stage(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAirTemp() {
        return AirTemp;
    }

    public void setAirTemp(String airTemp) {
        AirTemp = airTemp;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        Humidity = humidity;
    }

    public String getSoilTemp() {
        return SoilTemp;
    }

    public void setSoilTemp(String soilTemp) {
        SoilTemp = soilTemp;
    }

    public String getSoilMoisture() {
        return SoilMoisture;
    }

    public void setSoilMoisture(String soilMoisture) {
        SoilMoisture = soilMoisture;
    }

    public String getLightLevel() {
        return LightLevel;
    }

    public void setLightLevel(String lightLevel) {
        LightLevel = lightLevel;
    }
}
