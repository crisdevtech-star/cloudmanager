import Abstract.CloudResource;
import Classes.DataCenter;
import Entities.BlobStorage;
import Entities.VirtualMachine;
import Enums.Region;
import Inmutable.Workload;

void main() {


    VirtualMachine virtualOne = new VirtualMachine("1", Region.EU_WEST,25,40,50,100);
    VirtualMachine virtualTwo = new VirtualMachine("2", Region.EU_WEST,55,50,50,100);
    BlobStorage blockStorage = new BlobStorage("3",Region.LATAM_SOUTH,250,500);

    List<CloudResource> resources = new ArrayList<>();

    resources.add(virtualOne);
    resources.add(virtualTwo);
    resources.add(blockStorage);

    Workload workload = new Workload("4",50,25);

    DataCenter myData = new DataCenter(resources);

    myData.deploy(workload);
    blockStorage.shutdown();
    myData.purgeOfflineResources();

}
