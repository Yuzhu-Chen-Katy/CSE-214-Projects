// Yuzhu Chen 113516748 R04
public class RandomGenerator {
	public static Ride selectRide(Ride[] rides) {
		int rideNum = (int) (Math.random()*3);
		return rides[rideNum];
    }

}
