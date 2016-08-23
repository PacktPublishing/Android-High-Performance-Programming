int level = intentBatteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
int scale = intentBatteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

float batteryPercentage = level / (float)scale;
