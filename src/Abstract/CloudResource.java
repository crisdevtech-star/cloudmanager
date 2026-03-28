package Abstract;

import Enums.Region;

public abstract class CloudResource {

    private String id;
    private Region region;
    private boolean isActive;


    public CloudResource(String id, Region region) {
        this.id = id;
        this.region = region;
        this.isActive = true;
    }

    public CloudResource(String id, Region region, boolean is_active) {
        this.id = id;
        this.region = region;
        this.isActive = is_active;
    }

    public abstract double calculateMonthlyCost();

   public  void shutdown() {
        this.isActive = false;
    }

    public  boolean isActive(){
       return  this.isActive;
    }

    public String getId(){
       return  this.id;
    }

}
