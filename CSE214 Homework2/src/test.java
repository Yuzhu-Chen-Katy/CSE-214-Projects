import java.util.Scanner;
public class test {
	Day day;

	public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	
	    
	    public test(Day day) {
	        this.day = day;
	    }
	    
	    public void tellItLikeItIs() {
	        switch (day) {
	            case MONDAY:
	                System.out.println("Mondays are bad.");
	                break;
	                    
	            case FRIDAY:
	                System.out.println("Fridays are better.");
	                break;
	                         
	            case SATURDAY: case SUNDAY:
	                System.out.println("Weekends are best.");
	                break;
	                        
	            default:
	                System.out.println("Midweek days are so-so.");
	                break;
	        }
	    }
	    
	    public static void main(String[] args) {
	        test firstDay = new test(Day.MONDAY);
	        firstDay.tellItLikeItIs();
	       test thirdDay = new test(Day.WEDNESDAY);
	       thirdDay.tellItLikeItIs();
	       //test none = new test(Day.AAA);
	       
	    }
	}


