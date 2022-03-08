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
                    textView.text = tag
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
                    textView.text = tag
                }
                // If the focus left, update the listener
                listener?.onChange()
            }
        }
    }

    @BindingAdapter("numberOfInitColumns")
    @JvmStatic
    fun setNumberOfInitColumns(view: EditText, value: String) {
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "numberOfInitColumns")
    @JvmStatic
    fun getNumberOfInitColumns(editText: EditText): String {
        return editText.text.toString()
    }

    @BindingAdapter("numberOfInitColumnsAttrChanged")
    @JvmStatic
    fun setInitColumnsListener(view: EditText, listener: InverseBindingListener?) {
        view.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
            val textView = focusedView as TextView
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                view.setTag(R.id.previous_value, textView.text)
                textView.text = ""
            } else {
                if (textView.text.isEmpty()) {
                    val tag: CharSequence = textView.getTag(R.id.previous_value) as CharSequence
                    textView.text = tag
                }
                // If the focus left, update the listener
                listener?.onChange()
            }
        }
    }

    @BindingAdapter("numberOfInitRows")
    @JvmStatic
    fun setNumberOfInitRows(view: EditText, value: String) {
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "numberOfInitRows")
    @JvmStatic
    fun getNumberOfInitRows(editText: EditText): String {
        return editText.text.toString()
    }

    @BindingAdapter("numberOfInitRowsAttrChanged")
    @JvmStatic
    fun setInitRowsListener(view: EditText, listener: InverseBindingListener?) {
        view.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
            val textView = focusedView as TextView
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                view.setTag(R.id.previous_value, textView.text)
                textView.text = ""
            } else {
                if (textView.text.isEmpty()) {
                    val tag: CharSequence = textView.getTag(R.id.previous_value) as CharSequence
                    textView.text = tag
                }
                // If the focus left, update the listener
                listener?.onChange()
            }
        }
    }

    @BindingAdapter("direction")
    @JvmStatic
    fun setDirection(view: EditText, value: String) {
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "direction")
    @JvmStatic
    fun getDirection(editText: EditText): String {
        return editText.text.toString()
    }

    @BindingAdapter("directionAttrChanged")
    @JvmStatic
    fun setDirectionListener(view: EditText, listener: InverseBindingListener?) {
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

    @InverseMethod("stringToNumberOfInitColumns")
    @JvmStatic
    fun setInitColumnsToString(unused: Context, value: Int): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToNumberOfInitColumns(unused: Context, value: String) = value.toInt()

    @InverseMethod("stringToNumberOfInitRows")
    @JvmStatic
    fun setInitRowsToString(unused: Context, value: Int): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToNumberOfInitRows(unused: Context, value: String) = value.toInt()

    @InverseMethod("directionToChar")
    @JvmStatic
    fun setDirection(unused: Context, value: String): String {
        return value
    }

    @JvmStatic
    fun directionToChar(unused: Context, value: String) = value
}