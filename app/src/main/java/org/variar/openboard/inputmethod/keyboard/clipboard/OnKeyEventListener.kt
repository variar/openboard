package org.variar.openboard.inputmethod.keyboard.clipboard

interface OnKeyEventListener {

    fun onKeyDown(clipId: Long)

    fun onKeyUp(clipId: Long)

}