#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

JNIEXPORT jint JNICALL Java_id_ac_ui_cs_mobileprogramming_darinamanda_helloworld_MainActivity_fivemultiplier(JNIEnv * env, jobject this,  jint number){
    int n = 5;
    return number*n;
}