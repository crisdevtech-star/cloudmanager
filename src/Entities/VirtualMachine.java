package Entities;

import Abstract.CloudResource;
import Enums.Region;
import Exceptions.InsufficientCapacityException;
import Inmutable.Workload;
import Interfaces.Allocatable;

public class VirtualMachine extends CloudResource implements Allocatable {

    private double total_ram;
    private double total_cpu;
    private double used_ram;
    private double used_cpu;

    public VirtualMachine(String id, Region region, double total_ram,double used_ram,double total_cpu,double used_cpu) {
        super(id, region);
        this.total_ram = total_ram;
        this.used_ram = used_ram;
        this.total_cpu = total_cpu;
        this.used_cpu = used_cpu;
    }

    @Override
    public double calculateMonthlyCost() {


        return 0;
    }

    @Override
    public boolean allocate(Workload workload) throws InsufficientCapacityException {

        boolean resultRam = (this.total_ram - this.used_ram) >= workload.requiredRamRb();
        boolean resultCpu = (this.total_cpu - this.used_cpu) >= workload.requiredCpuCores();
        try {
            return  resultCpu && resultRam;
        } catch (Exception e) {
            throw new InsufficientCapacityException(e.getMessage());
        }
    }
}
