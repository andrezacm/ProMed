package controllers;

public abstract class Security {
	private static boolean authorized = false;
	
	public static void setAuthorized(boolean autorizado){
		authorized = autorizado;
	}
	
	public static boolean isAuthorized(){
		return authorized;
	}
	
}
