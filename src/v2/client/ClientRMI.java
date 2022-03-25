package v2.client;

import java.rmi.Naming;

public class ClientRMI {
    public static void main(String [] args){

        /*
        Normalement la partie client c'est un autre projet dans un autre serveur.
        Mais l'idee de cet exercice est d'explique l'architecture de comment le client va conserver les services à partir d'un serveur web et a partir de la notion RMI JAVA
         */
        try {
            IService stub = (IService) Naming.lookup("rmi : http://localhost:8050/1.1/service");
            System.out.println(stub.getService());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
