package Interfaces;

import Exceptions.InsufficientCapacityException;
import Inmutable.Workload;

public interface Allocatable {
    boolean allocate(Workload workload) throws InsufficientCapacityException;
}
