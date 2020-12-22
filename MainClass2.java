package test;

public class MainClass2 {
	
	static String actualMeridiem;
	static int actutalHour, actualMinute;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(function("9:10 AM",-200));
		
	}
	
	public static String function(String time, int minutes) {
		 actutalHour = Integer.valueOf(time.split(":")[0].trim());
		 actualMinute = Integer.valueOf(time.split(" ")[0].split(":")[1].trim());
		 actualMeridiem = time.split(" ")[1].trim();
		 
		int hoursNeedToAddDelete = minutes/60;
		System.out.println(hoursNeedToAddDelete);
		int minutesNeedToAddDelete = minutes%60;
		System.out.println(minutesNeedToAddDelete);
		calculateMinutes(actualMinute, minutesNeedToAddDelete);
		calculateHours(hoursNeedToAddDelete);
		
		return actutalHour+":"+actualMinute+" "+actualMeridiem;
	}
	
	
	
	public static void calculateMinutes(int actualMinutes, int addDeletMinutes) {
		int newMinutes = actualMinutes + addDeletMinutes ;
		if(newMinutes < 0) {
			actualMinute = 60 + newMinutes;
			actutalHour = actutalHour -1;
			calculateMeridiem(actutalHour);
		}else {
			if(newMinutes>59) {
				actualMinute = newMinutes - 59;
				actutalHour = actutalHour +1;
				calculateMeridiem(actutalHour);
			}else {
				actualMinute = newMinutes;
			}
		}
	}
	
	public static void calculateHours(int hoursNeedToAddDelete) {
		if(hoursNeedToAddDelete <0) {
			for(int i =hoursNeedToAddDelete; i<0; i++) {
				actutalHour = actutalHour - 1;
				if(actutalHour==0) {
					if(actutalHour==-1) {
						actutalHour= 11;
						continue;
					}
					calculateMeridiem(actutalHour);
				}
				
			}
		}else {
		for(int i =hoursNeedToAddDelete; i>0; i--) {
			actutalHour = actutalHour + 1;
			if(actutalHour>=12) {
				if(actutalHour==13) {
					actutalHour= 0;
					continue;
				}
				calculateMeridiem(actutalHour);
			}
			
		}
		}
	}
	
	public static void calculateMeridiem(int actualHours) {
		if(actualHours >= 12) {
			if(actualMeridiem.equals("AM")) {
				actualMeridiem = "PM";
			}
			else {
				actualMeridiem = "AM";
			}
		}
	}

}
