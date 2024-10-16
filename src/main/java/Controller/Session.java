package Controller;

import Entities.Actor;
import Entities.Admin;
import Entities.Producteur;
import Entities.User;

public class Session {

	private static Producteur connectedProducer;
	private static User connecteduser;
	private static Actor connectedactor;
	private static Admin connectedadmin;
	
	public static Admin getConnectedadmin() {
		return connectedadmin;
	}
	public static void setConnectedadmin(Admin connectedadmin) {
		Session.connectedadmin = connectedadmin;
	}
	public static Producteur getConnectedProducer() {
		return connectedProducer;
	}
	public static void setConnectedProducer(Producteur connectedProducer) {
		Session.connectedProducer = connectedProducer;
	}
	public static User getConnecteduser() {
		return connecteduser;
	}
	public static void setConnecteduser(User connecteduser) {
		Session.connecteduser = connecteduser;
	}
	public static Actor getConnectedactor() {
		return connectedactor;
	}
	public static void setConnectedactor(Actor connectedactor) {
		Session.connectedactor = connectedactor;
	}
	
	
	

   
}
