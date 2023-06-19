package com.jingwei.sdui.core.component.attribute

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

sealed interface SduiModifier {
    val height: Int?
    val width: Int?
    val padding: SduiPadding
    val aspectRatio: Float?
    val background: SduiBackground?
    val border: SduiBorder?
    val grow: Float
}

enum class ModifierType {
    BASIC, FLEX, ABSOLUTE,
}


data class SduiBaseModifier(
    override val height: Int? = null,
    override val width: Int? = null,
    override val padding: SduiPadding = NONE_PADDING,
    override val aspectRatio: Float? = null,
    override val background: SduiBackground? = null,
    override val border: SduiBorder? = null,
    override val grow: Float = 0f,
) : SduiModifier

data class SduiFlexModifier(
    override val height: Int? = null,
    override val width: Int? = null,
    override val padding: SduiPadding = NONE_PADDING,
    override val aspectRatio: Float? = null,
    override val background: SduiBackground? = null,
    override val border: SduiBorder? = null,
    override val grow: Float = 0f,
    val flexAlignment: SduiCrossAxisAlignment = SduiCrossAxisAlignment.START,
) : SduiModifier

data class SduiAbsoluteModifier(
    override val height: Int? = null,
    override val width: Int? = null,
    override val padding: SduiPadding = NONE_PADDING,
    override val aspectRatio: Float? = null,
    override val background: SduiBackground? = null,
    override val border: SduiBorder? = null,
    override val grow: Float = 0f,
    val absoluteAlignment: SduiAbsoluteAlignment = SduiAbsoluteAlignment.TOP_START
) : SduiModifier


fun SduiModifier?.toModifier(scope: Any?, fractional: Float): Modifier {
    if (this == null) {
        return Modifier
    }
    val modifiers = mutableListOf<Modifier?>()

    modifiers += height?.let {
        Modifier.height(it.dp)
    }
    modifiers += width?.let {
        Modifier.width(it.dp)
    }
    modifiers += padding.takeIf { it != NONE_PADDING }?.let {
        Modifier.padding(
            start = it.start.dp,
            end = it.end.dp,
            top = it.top.dp,
            bottom = it.bottom.dp
        )
    }
    modifiers += border?.let {
        Modifier.border(width = it.width.dp, color = it.color.toColor(), shape = it.shape.toShape())
    }
    modifiers += aspectRatio?.let {
        Modifier.aspectRatio(it)
    }
    modifiers += background?.let {
        Modifier.background(color = it.color.toColor(), shape = it.shape.toShape())
    }

    modifiers += Modifier.composed {
        when(this@toModifier) {
            is SduiAbsoluteModifier -> {
                if (scope !is BoxScope) {
                    throw IllegalArgumentException("Should be BoxScope")
                }
                scope.run {
                    align(absoluteAlignment.toAlignment())
                }
            }
            is SduiFlexModifier -> {
                when(scope) {
                    is ColumnScope ->
                        scope.run {
                            align(flexAlignment.toHorizontalAlignment())
                        }

                    is RowScope ->
                        scope.run {
                            align(flexAlignment.toVerticalAlignment())
                        }
                    else -> throw IllegalArgumentException("Should be ColumnScope or RowScope")
                }
            }
            else -> {
                return@composed Modifier
            }
        }
    }

    modifiers += calculateGrow(fractional, scope)
    return modifiers.filterNotNull().reduce { acc, modifier -> acc.then(modifier) }

}

private fun calculateGrow(fractional: Float, scope: Any?): Modifier {
    return when {
        fractional == 0f ->  Modifier
        fractional < 1f -> Modifier.composed {
            when(scope) {
                is ColumnScope -> fillMaxHeight(fractional)
                is RowScope -> fillMaxWidth(fractional)
                is BoxScope -> fillMaxWidth(fractional)
                else -> fillMaxWidth(fractional)
            }
        }
        fractional >= 1 -> Modifier.composed {
            when(scope) {
                is ColumnScope -> scope.run {
                    weight(fractional)
                }
                is RowScope ->  scope.run {
                    weight(fractional)
                }
                else -> fillMaxWidth()
            }
        }
        else -> throw IllegalArgumentException("fractional can't be negative")
    }
}

fun SduiModifier?.fractional(): Float {
    return (this?.grow ?: 0f) / 1f
}







