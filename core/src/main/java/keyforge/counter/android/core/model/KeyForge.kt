package keyforge.counter.android.core.model

import keyforge.counter.android.core.model.key.BlueKey
import keyforge.counter.android.core.model.key.RedKey
import keyforge.counter.android.core.model.key.YellowKey

data class KeyForge(
    var amberCounter: Int = 0,
    var totalAmberToForgeKey: Int = 4,
    var chain: Chain? = null,
    var blueKey: BlueKey? = null,
    var yellowKey: YellowKey? = null,
    var redKey: RedKey? = null
) {
    fun canForge(): Boolean = totalAmberToForgeKey <= amberCounter
}