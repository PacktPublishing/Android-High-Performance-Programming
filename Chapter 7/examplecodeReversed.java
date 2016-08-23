String str1 = "MyName";
int i = str1.length();
String str2 = "";
String str3 = "00000";
while (true) {

	Toast.makeText(mainActivity, "Min 4 chars", 1).show();

	String str4 = String.valueOf(0x6B016 ^ Integer.parseInt(str2.substring(0, 5)));
	TelephonyManager localTelephonyManager = (TelephonyManager) mainActivity.getSystemService("phone");
	String str5 = localTelephonyManager.getDeviceId();
	String str6 = localTelephonyManager.getSimSerialNumber();
	String str7 = str5.substring(0, 6);
	String str8 = str6.substring(0, 6);
	long l = Integer.parseInt(str7) ^ Integer.parseInt(str8);
	if (!(str4 + "-" + String.valueOf(l) + "-" + str7).equals(str3)) {
		Toast.makeText(mainActivity, "God boy", 1).show();
	}
