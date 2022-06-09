package keyforge.counter.android.core.model

class Chain(
    var current: Int = 0
) {
    fun getPunishment(): Int {
        if (current in 1..6) return -1

        if (current in 7..12) return -2

        if (current in 13..18) return -3

        if (current > 18) return -4

        return 0
    }
}