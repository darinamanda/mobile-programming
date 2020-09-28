package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld

import org.junit.Assert.assertEquals
import org.junit.Test
import android.R
import android.widget.Button


class ThanksActivityUnitTest {

    @Test
    fun testNewTextContent() {
        val activity = ThanksActivity()
        assertEquals("Terima kasih karena sudah berjuang sampai hari ini", activity.newText())
    }
}