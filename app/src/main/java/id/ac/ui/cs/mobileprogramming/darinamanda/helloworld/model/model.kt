package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.model
import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.R

data class Powerpuff(
    val id: String?,
    val name: String?,
    val type: String?,
    val image: Int
)


val blossoms = Powerpuff(
    "1",
    "Blossom",
    "Red, pink",
    R.drawable.blossom
)

val buttercup = Powerpuff(
    "2",
    "Powerpuff",
    "Green",
    R.drawable.buttercup
)

val bubbles = Powerpuff(
    "3",
    "Bubble",
    "Yellow, blue",
    R.drawable.bubbles
)


val powerpuffDb = arrayListOf(
    blossoms, buttercup, bubbles
)