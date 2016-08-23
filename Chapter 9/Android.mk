LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := HelloWorld-jni
LOCAL_SRC_FILES := HelloWorld-jni.c

include $(BUILD_SHARED_LIBRARY)
