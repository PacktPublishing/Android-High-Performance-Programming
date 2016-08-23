TrafficStats.setThreadStatsTag(0xF00000);
try {
     // make your network request
} finally {
    TrafficStats.clearThreadStatsTag();
}
