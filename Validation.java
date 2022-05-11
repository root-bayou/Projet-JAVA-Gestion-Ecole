package imane;

public class Validation {
	
	public Validation() {
		
	}
	
	 public boolean isValidEmail( String email ) {
	        //String regExp = "^.+@.+\\..+$";
	        String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";
	        return email.matches( regExp );
	    }
	    
	    public boolean isValidnum( String num ) {
	        //String regExp = "^.+@.+\\..+$";
	        String regExp = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
	        return num.matches( regExp );
	    }
	    
	  public boolean isValideDate (String date) { 
		  String regExp =  "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
			      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
			      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
			      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
		return date.matches(regExp);
	  }

	
}
