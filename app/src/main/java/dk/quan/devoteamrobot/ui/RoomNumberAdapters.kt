package dk.quan.devoteamrobot.ui

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseMethod
import dk.quan.devoteamrobot.R

object RoomNumberAdapters {
    @BindingAdapter("numberOfColumns")
    @JvmStatic
    fun setNumberOfColumns(view: EditText, value: String) {
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "numberOfColumns")
    @JvmStatic
    fun getNumberOfColumns(editText: EditText): String {
        return editText.text.toString()
    }

    @BindingAdapter("numberOfColumnsAttrChanged")
    @JvmStatic
    fun setColumnsListener(view: EditText, listener: InverseBindingListener?) {
        view.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
            val textView = focusedView as TextView
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                view.setTag(R.id.previous_value, textView.text)
                textView.text = ""
            } else {
                if (textView.text.isEmpty()) {
                    val tag: CharSequence = textView.getTag(R.id.previous_value) as CharSequence
                    textView.text = tag ?: ""
                }
                // If the focus left, update the listener
                listener?.onChange()
            }
        }
    }

    @BindingAdapter("numberOfRows")
    @JvmStatic
    fun setNumberOfRows(view: EditText, value: String) {
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "numberOfRows")
    @JvmStatic
    fun getNumberOfRows(editText: EditText): String {
        return editText.text.toString()
    }

    @BindingAdapter("numberOfRowsAttrChanged")
    @JvmStatic
    fun setRowsListener(view: EditText, listener: InverseBindingListener?) {
        view.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
            val textView = focusedView as TextView
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                view.setTag(R.id.previous_value, textView.text)
                textView.text = ""
            } else {
                if (textView.text.isEmpty()) {
                    val tag: CharSequence = textView.getTag(R.id.previous_value) as CharSequence
                    textView.text = tag ?: ""
                }
                // If the focus left, update the listener
                listener?.onChange()
            }
        }
    }
}

object RoomNumberConverters {
    @InverseMethod("stringToNumberOfColumns")
    @JvmStatic
    fun setColumnsToString(unused: Context, value: Int): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToNumberOfColumns(unused: Context, value: String) = value.toInt()

    @InverseMethod("stringToNumberOfRows")
    @JvmStatic
    fun setRowsToString(unused: Context, value: Int): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToNumberOfRows(unused: Context, value: String) = value.toInt()
}