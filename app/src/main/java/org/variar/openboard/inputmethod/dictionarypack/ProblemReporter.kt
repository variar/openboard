package org.variar.openboard.inputmethod.dictionarypack

/**
 * A simple interface to report problems.
 */
interface ProblemReporter {
    fun report(e: Exception?)
}