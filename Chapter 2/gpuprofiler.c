#include <android/log.h>
#include <dlfcn.h>


#define PACKAGE_NAME "" // Fill this in with the actual package name
#define GAPII_SO_PATH "/data/data/" PACKAGE_NAME "/lib/libgapii.so"


struct GapiiLoader {
   GapiiLoader() {
       if (!dlopen(GAPII_SO_PATH, RTLD_LOCAL | RTLD_NOW)) {
           __android_log_print(ANDROID_LOG_ERROR, "GAPII", "Failed loading " GAPII_SO_PATH);
       }
   }
};

GapiiLoader __attribute__((used)) gGapiiLoader;

In order to load it into the main class, the following code snippet must be used:

static {
    System.loadLibrary("gapii");
}
