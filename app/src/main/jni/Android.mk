TOP_LOCAL_PATH:=$(call my-dir)
include $(call all-subdir-makefiles)
LOCAL_PATH := $(TOP_LOCAL_PATH)

include $(CLEAR_VARS)
LOCAL_MODULE := multiply
LOCAL_SRC_FILES := multiply.c
include $(BUILD_SHARED_LIBRARY)