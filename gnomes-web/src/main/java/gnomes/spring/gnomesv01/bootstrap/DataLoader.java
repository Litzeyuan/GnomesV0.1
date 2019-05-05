package gnomes.spring.gnomesv01.bootstrap;

import gnomes.spring.gnomesv01.services.interfaces.*;
import org.springframework.boot.CommandLineRunner;

//@Component
public class DataLoader implements CommandLineRunner {

    private final LocationService locationService;
    private final AreaService areaService;
    private final BedService bedService;
    private final CropService cropService;
    private final StageService stageService;


    public DataLoader(LocationService locationService,
                      AreaService areaService,
                      BedService bedService,
                      CropService cropService,
                      StageService stageService
                      ) {
        this.locationService = locationService;
        this.areaService = areaService;
        this.bedService = bedService;
        this.cropService = cropService;
        this.stageService = stageService;

    }

    @Override
    public void run(String... args) throws Exception {
//        Location dcu = new Location("Dcu","Glasnevin, Dublin 9");
//        locationService.save(dcu);
//
//        Crop crop1 = new Crop("Beetroot","Feur Kugal");
//        cropService.save(crop1);

    }
}
