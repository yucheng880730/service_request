import java.util.*;

class ServiceRequests{

	ServiceBackUpException sb = new ServiceBackUpException();
	NoServiceRequestException ns = new NoServiceRequestException();

	String[] req = new String[10];

	int ik = 0;
	
	public void addName(String name){

		if(ik == req.length)
			sb.sbue();

		else 
			req[ik++] = name;

	}

	public void removeName(String name){

		int f = -1;

		for(int i = 0; i < getNumber(); i++){

			if(req[i].equals(name))
				f = i;

		}

		if (f == -1){

			ns.nsre();

		} else {

			//there are request to remove
			for(int i = f; i < getNumber()-1; i++){

				req[i] = req[i + 1];
				//req[getNumber()-2] = req[getNumber()-1];
				//ik--;

			}

			ik = ik -1;
		}

	}

	public String getName(int i){

		if(i>=0 && i< req.length)
			return req[i];
		else  
			return "Given number more than size of array";

	}

	public int getNumber(){
		return ik;
	}
}

/*******************************************************************************************/

class MyException extends Exception{

}

/*******************************************************************************************/

class ServiceBackUpException{

	public void sbue(){

		try{
			throw new MyException();
		}

		catch(MyException ex){ 
			System.out.println("Cannot add as the list is full");
		}

	}

}

/*******************************************************************************************/

class NoServiceRequestException{ // for request not in the list exception

	public void nsre(){

		try{
			throw new MyException();
		}

		catch(MyException ex){ 
			System.out.println("Sorry, that name was not in the list");
		}

	}

}

/*******************************************************************************************/

public class service_request{

	public static void main (String[] args){

		char ch;

		String re;

		ServiceRequests sr = new ServiceRequests();

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Service Request program");

		do{

			System.out.println("Add a request (A), Remove a request (R), Show all requests (S) or quit (Q)");

			ch = sc.next().charAt(0);

			switch(ch){

				case 'A':
					System.out.println("What is the name to add?");
					re = sc.next();
					sr.addName(re);
					break;

				case 'R':
					System.out.println("What is the name to remove?");
					re = sc.next(); // getting from user
					sr.removeName(re); // calling remove request method
					break;

				case 'S':
					System.out.println("Current requests are:");
					for(int i=0; i<sr.ik; i++) { // print all requests

						System.out.println("Request "+i+" is "+sr.req[i]);

					}
					System.out.println("");
					break;

				case 'Q':
					System.out.println("Ok. We are done.");
					System.exit(0); // exit from program

				default:
					System.out.println("Enter only the given options!!!");
			}

		}while(true);   
	}

}

