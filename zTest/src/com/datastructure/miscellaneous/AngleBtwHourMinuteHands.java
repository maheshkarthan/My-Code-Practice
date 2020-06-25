package com.datastructure.miscellaneous;

/*The 'minute' hand moves 360 degree in 60 minute(or 6 degree in one minute) ==> 360/60 = 6
 * and 'hour'  hand moves 360 degree in 12 hours (or 0.5 degree in 1 minute) ==> 360/(12*60) = 0.5. 
 * In h hours and m minutes, 
 * the minute hand would move (h*60 + m)*6 and hour hand would move (h*60 + m)*0.5.
 */
public class AngleBtwHourMinuteHands {

	static int calcAngle(double h, double m) {
		// validate the input
		if (h < 0 || m < 0 || h > 12 || m > 60)
			System.out.println("Wrong input");

		if (h == 12)
			h = 0;
		if (m == 60)
			m = 0;

		// Calculate the angles moved by hour and minute hands
		int hour_angle = (int) (0.5 * (h * 60 + m));
		int minute_angle = (int) (6 * m);

		// Find the difference between two angles
		int angle = Math.abs(hour_angle - minute_angle);

		// smaller angle of two possible angles
		angle = Math.min(360 - angle, angle);

		return angle;
	}

	// Driver program
	public static void main(String[] args) {
		System.out.println(calcAngle(9, 60) + " degree");
		System.out.println(calcAngle(3, 30) + " degree");
	}
}
