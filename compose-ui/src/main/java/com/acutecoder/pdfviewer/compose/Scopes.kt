package com.acutecoder.pdfviewer.compose

import androidx.compose.foundation.layout.BoxScope

open class PdfContainerScope internal constructor(
    internal val pdfState: PdfState
)

class PdfContainerBoxScope internal constructor(
    pdfState: PdfState,
    private val boxScope: BoxScope
) : PdfContainerScope(pdfState), BoxScope by boxScope

class PdfToolBarScope internal constructor(
    val pdfState: PdfState,
    val isFindBarOpen: () -> Boolean,
    val closeFindBar: () -> Unit
)
