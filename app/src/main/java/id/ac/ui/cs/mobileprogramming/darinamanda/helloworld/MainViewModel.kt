package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld


import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val seconds = MutableLiveData<Int>()
    private val minutes = MutableLiveData<Int>()

    private val msTime = MutableLiveData<Long>()
    private val startTime = MutableLiveData<Long>()
    private val updateTime = MutableLiveData<Long>()
    private val timeBuff = MutableLiveData<Long>()

    val exitTime = MutableLiveData<Long>()
    val resume = MutableLiveData<Boolean>()
    val strTime = MutableLiveData<String>()
    val pauseTime = MutableLiveData<String>()

    init {
        reset()
    }

    fun reset() {
        seconds.value = 0
        minutes.value = 0
        msTime.value = 0L
        startTime.value = 0L
        exitTime.value = 0L
        updateTime.value = 0L
        timeBuff.value = 0L
        resume.value = false
        strTime.value = "00:00"
        pauseTime.value = ""
    }

    fun onPause() {
        timeBuff.value = msTime.value!!
    }

    fun onStart() {
        startTime.value = SystemClock.uptimeMillis()
    }

    fun onExit() {
        exitTime.value = SystemClock.uptimeMillis()
    }

    fun onRunning() {
        if (timeBuff.value != 0L) {
            msTime.value = timeBuff.value!!
            removeBuffer()
        } else {
            msTime.value = SystemClock.uptimeMillis() - startTime.value!!
        }

        updateTime.value = msTime.value!!
        seconds.value = (updateTime.value!! / 1000).toInt()

        minutes.value = seconds.value!! / 60
        seconds.value = seconds.value!! % 60

        strTime.value =
            "%02d:%02d".format(minutes.value!!, seconds.value!!)
    }

    fun changeState() {
        resume.value = resume.value!!.not()
    }

    fun removeBuffer() {
        startTime.value = startTime.value!! + 1000
        timeBuff.value = 0L
    }


    fun pausedTime() {
        var msTime = SystemClock.uptimeMillis() - exitTime.value!!
        var updateTime = msTime
        var seconds = (updateTime / 1000).toInt()

        var minutes = seconds / 60
        seconds %= 60

        pauseTime.value = "Lost Focus : %02d m %02d s".format(minutes, seconds)
    }

}