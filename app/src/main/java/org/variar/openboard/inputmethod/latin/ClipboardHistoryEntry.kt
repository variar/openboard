package org.variar.openboard.inputmethod.latin

data class ClipboardHistoryEntry (
        var id: Long,
        val content: CharSequence,
        var isPinned: Boolean = false
) : Comparable<ClipboardHistoryEntry> {

    override fun compareTo(other: ClipboardHistoryEntry): Int {
        val result = other.isPinned.compareTo(isPinned)
        return if (result != 0) result else other.id.compareTo(id)
    }
}