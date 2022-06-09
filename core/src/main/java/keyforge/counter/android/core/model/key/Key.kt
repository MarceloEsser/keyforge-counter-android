package keyforge.counter.android.core.model.key

import keyforge.counter.android.core.model.KeyColor

sealed class Key(
    val isForged: Boolean,
    val amberQuantityUsedToForge: Int,
    internal val keyColor: KeyColor,
)