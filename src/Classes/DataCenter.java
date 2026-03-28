package Classes;

import Abstract.CloudResource;
import Exceptions.InsufficientCapacityException;
import Inmutable.Workload;
import Interfaces.Allocatable;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {

    private List<CloudResource> resources;


    public DataCenter(List<CloudResource> resources) {
        this.resources = new ArrayList<>(resources);
    }

    public void registerResource(CloudResource resource){
        this.resources.add(resource);
    }

    public double getClusterCost(){
        double resultSum = 0;
        for (CloudResource resource : this.resources ){
            resultSum += resource.calculateMonthlyCost(); // Falta implementar
        }
        return resultSum;
    }

   public void purgeOfflineResources(){
        this.resources.removeIf(resource -> !resource.isActive());
    }

    public boolean deploy(Workload workload) {
        for (CloudResource resource : this.resources) {
            if (resource instanceof Allocatable allocatableNode) {
                if (resource.isActive()) {
                    try {
                        if (allocatableNode.allocate(workload)) {
                            return true;
                        }
                    } catch (InsufficientCapacityException e) {
                        System.err.println("Rechazo de asignación en nodo [" + resource.getId() + "]: " + e.getMessage());
                    }
                }
            }
        }
        return false;
    }
}
