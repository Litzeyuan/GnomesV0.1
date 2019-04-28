package gnomes.spring.gnomesv01.bootstrap;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.models.Location;
import gnomes.spring.gnomesv01.services.interfaces.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final LocationService locationService;
    private final BedService bedService;
    private final CropService cropService;
    private final SowingStageService sowingStageService;
    private final GerminationStageService germinationStageService;

    public DataLoader(LocationService locationService,
                      BedService bedService,
                      CropService cropService,
                      SowingStageService sowingStageService,
                      GerminationStageService germinationStageService) {
        this.locationService = locationService;
        this.bedService = bedService;
        this.cropService = cropService;
        this.sowingStageService = sowingStageService;
        this.germinationStageService = germinationStageService;
    }

    @Override
    public void run(String... args) throws Exception {
        Location dcu = new Location();
        dcu.setName("DCU");
        dcu.setAddress("Glasnevin, Dublin 9");

        Location orchard = new Location();
        orchard.setName("Orchard");
        orchard.setAddress("Orchard");

        locationService.save(dcu);
        locationService.save(orchard);


        Crop crop1 = new Crop();
        crop1.setLocation("DCU");
        crop1.setQuantity(25);
        crop1.setFamily("Beetroot");
        crop1.setVariety("Feur Kugal");

        Crop crop2 = new Crop();
        crop2.setLocation("DCU");
        crop2.setQuantity(35);
        crop2.setFamily("Bok Choy");
        crop2.setVariety("Pak Choi");

        cropService.save(crop2);
        cropService.save(crop1);

    }
}
