package Entities;

import Abstract.CloudResource;
import Enums.Region;
import Exceptions.InsufficientCapacityException;
import Inmutable.Workload;
import Interfaces.Allocatable;

public class VirtualMachine extends CloudResource implements Allocatable {

    private double totalRam;
    private double totalCpu;
    private double usedRam;
    private double usedCpu;

    public VirtualMachine(String id, Region region, double totalRam,double usedRam,double totalCpu,double usedCpu) {
        super(id, region);
        this.totalRam = totalRam;
        this.usedRam = usedRam;
        this.totalCpu = totalCpu;
        this.usedCpu = usedCpu;
    }

    @Override
    public double calculateMonthlyCost() {
        return (this.totalCpu * 1.5) + (this.totalRam * 0.5);
    }

    @Override
    public boolean allocate(Workload workload) throws InsufficientCapacityException {
        boolean hasRam = (this.totalRam - this.usedRam) >= workload.requiredRamRb();
        boolean hasCpu = (this.totalCpu - this.usedCpu) >= workload.requiredCpuCores();
        if (!hasRam || !hasCpu) {
            throw new InsufficientCapacityException(
                "Capacidad insuficiente en VM [" + getId() + "]. " +
                "RAM requerida: " + workload.requiredRamRb() + "GB, " +
                "CPU requerida: " + workload.requiredCpuCores() + " cores."
            );
        }
        this.usedRam += workload.requiredRamRb();
        this.usedCpu += workload.requiredCpuCores();
        return true;
    }
}
