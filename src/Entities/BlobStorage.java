package Entities;

import Abstract.CloudResource;
import Enums.Region;

public class BlobStorage extends CloudResource {

    private  double capacityTb;
    private  double usedTb;

    public BlobStorage(String id, Region region, double capacityTb, double usedTb) {
        super(id, region);
        this.capacityTb = capacityTb;
        this.usedTb = usedTb;
    }

    @Override
    public double calculateMonthlyCost() {
        return this.usedTb * 0.02;
    }
}
