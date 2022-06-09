package keyforge.counter.android.core.model.key

import keyforge.counter.android.core.model.KeyColor

class BlueKey(isForged: Boolean, amberQuantityUsedToForge: Int) :
    Key(
        amberQuantityUsedToForge = amberQuantityUsedToForge,
        isForged = isForged,
        keyColor = KeyColor.blue
    )