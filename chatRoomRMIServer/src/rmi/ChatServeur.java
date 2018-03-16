package rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class ChatServeur {

	public static void main(String[] args) {
		try{
			LocateRegistry.createRegistry(1099);
			//lancement dynamique du registre de
			//instanciation d'un objet de la classe distante
			ChatRoomImpl chatRoomImpl = new ChatRoomImpl();
			//enregistrement dans le registre de noms RMI
			Naming.rebind("rmi://localhost:1099/TP0", chatRoomImpl);
			System.out.println("Serveur lancé");
			System.out.println(chatRoomImpl.toString());
		
		}catch(RemoteException e){
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
