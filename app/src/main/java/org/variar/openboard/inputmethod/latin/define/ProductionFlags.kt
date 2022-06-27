package org.variar.openboard.inputmethod.latin.define

object ProductionFlags {
    const val IS_HARDWARE_KEYBOARD_SUPPORTED = false

    /**
     * Include all suggestions from all dictionaries in
     * [org.variar.openboard.inputmethod.latin.SuggestedWords.mRawSuggestions].
     */
    const val INCLUDE_RAW_SUGGESTIONS = false

    /**
     * When `false`, the split keyboard is not yet ready to be enabled.
     */
    const val IS_SPLIT_KEYBOARD_SUPPORTED = true
}