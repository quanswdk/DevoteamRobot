package dk.quan.devoteamrobot.data

import androidx.databinding.Bindable
import dk.quan.devoteamrobot.BR
import dk.quan.devoteamrobot.util.ObservableViewModel

const val INITIAL_NUMBER_OF_COLUMNS = 5
const val INITIAL_NUMBER_OF_ROWS = 5

class RobotViewModel : ObservableViewModel() {

    private var numberOfColumnsTotal = INITIAL_NUMBER_OF_COLUMNS
    var numberOfColumns: Int = INITIAL_NUMBER_OF_COLUMNS
        @Bindable get() {
            return numberOfColumnsTotal
        }
        set(value) {
            if (value > 0) {
                field = value
                numberOfColumnsTotal = value
            }
            notifyPropertyChanged(BR.numberOfColumns)
        }

    fun setColumnsDecrease() {
        if (numberOfColumns > 0) {
            numberOfColumns -= 1
            notifyPropertyChanged(BR.numberOfColumns)
        }
    }

    fun setColumnsIncrease() {
        numberOfColumns += 1
        notifyPropertyChanged(BR.numberOfColumns)
    }

    private var numberOfRowsTotal = INITIAL_NUMBER_OF_ROWS
    var numberOfRows: Int = INITIAL_NUMBER_OF_ROWS
        @Bindable get() {
            return numberOfRowsTotal
        }
        set(value) {
            if (value > 0) {
                field = value
                numberOfRowsTotal = value
            }
            notifyPropertyChanged(BR.numberOfRows)
        }

    fun setRowsDecrease() {
        if (numberOfRows > 0) {
            numberOfRows -= 1
            notifyPropertyChanged(BR.numberOfRows)
        }
    }

    fun setRowsIncrease() {
        numberOfRows += 1
        notifyPropertyChanged(BR.numberOfRows)
    }
}