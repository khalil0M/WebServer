package v2.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

    protected ServiceImpl() throws RemoteException {
    }

    @Override
    public Service getService() {
        return new Service();
    }
}
