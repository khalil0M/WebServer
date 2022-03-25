package v2.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {

    public static void main(String [] args){
        try {
            LocateRegistry.createRegistry(8050);
            ServiceImpl service = new ServiceImpl();
            Naming.rebind("rmi : http://localhost:8050/1.1/service",service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
