package com.example.misutest.util

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.text.TextPaint
import com.example.misutest.App

class ConvertStringToBitmap {
    companion object {
        private var texSize = 0F
        fun avatarImage(
            size: Int,
            name: String,
            secondName: String,
        ): BitmapDrawable {
            return avatarImageGenerate(
                size,
                name,
                secondName)
        }

        private fun avatarImageGenerate(
            size: Int,
            name: String,
            secondName: String,
        ): BitmapDrawable {
            val uiContext = App.getContext()
            texSize = calTextSize(size)
            val label = firstCharacter(name, secondName)
            val textPaint = textPainter(uiContext)
            val painter = painter()
            painter.isAntiAlias = true
            val areaRect = Rect(0, 0, size, size)
            painter.color = Color.TRANSPARENT

            val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            canvas.drawRect(areaRect, painter)

            val bounds = RectF(areaRect)
            bounds.right = textPaint.measureText(label, 0, 1)
            bounds.bottom = textPaint.descent() - textPaint.ascent()

            bounds.left += (areaRect.width() - bounds.right) / 2.75f
            bounds.top += (areaRect.height() - bounds.bottom) / 2f

            canvas.drawCircle(size.toFloat() / 2, size.toFloat() / 2, size.toFloat() / 2, painter)
            canvas.drawText(label, bounds.left, bounds.top - textPaint.ascent(), textPaint)
            return BitmapDrawable(uiContext.resources, bitmap)
        }

        private fun firstCharacter(name: String, secondName: String): String {
            val concatenation =
                name.first().uppercase() + secondName.first()
                    .uppercase()
            return concatenation
        }

        private fun textPainter(context: Context): TextPaint {
            val textPaint = TextPaint()
            textPaint.isAntiAlias = true
            textPaint.textSize = texSize * context.resources.displayMetrics.scaledDensity
            textPaint.color = Color.BLACK
            return textPaint
        }

        private fun painter(): Paint {
            return Paint()
        }

        private fun calTextSize(size: Int): Float {
            return (size / 10).toFloat()
        }

    }


}