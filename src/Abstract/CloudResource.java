package Abstract;

import Enums.Region;

public abstract class CloudResource {

    private String id;
    private Region region;
    private boolean is_active;


    public CloudResource(String id, Region region) {
        this.id = id;
        this.region = region;
        this.is_active = true;
    }

    public CloudResource(String id, Region region, boolean is_active) {
        this.id = id;
        this.region = region;
        this.is_active = is_active;
    }

    public abstract double calculateMonthlyCost();

   public  void shutdown() {
        this.is_active = false;
    }

    public  boolean isActive(){
       return  this.is_active;
    }

    public String getId(){
       return  this.id;
    }

}
