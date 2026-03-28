package Entities;

import Abstract.CloudResource;
import Enums.Region;

public class BlobStorage extends CloudResource {

    private  double capacity_tb;
    private  double used_tb;

    public BlobStorage(String id, Region region, double capacity_tb, double used_tb) {
        super(id, region);
        this.capacity_tb = capacity_tb;
        this.used_tb = used_tb;
    }

    @Override
    public double calculateMonthlyCost() {
        return this.used_tb * 0.02;
    }
}
