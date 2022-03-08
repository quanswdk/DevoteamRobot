package dk.quan.devoteamrobot.data

import android.content.Context
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import dk.quan.devoteamrobot.BR
import dk.quan.devoteamrobot.util.ObservableViewModel

const val INITIAL_NUMBER_OF_COLUMNS = 5
const val INITIAL_NUMBER_OF_ROWS = 5
const val INITIAL_NUMBER_OF_INIT_COLUMNS = 3
const val INITIAL_NUMBER_OF_INIT_ROWS = 3
const val INITIAL_DIRECTION = "N"

class RobotViewModel : ObservableViewModel() {

    val positionsObservable: MutableLiveData<String> = MutableLiveData("")

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
            clearPositions()
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
            clearPositions()
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

    private var numberOfInitColumnsTotal = INITIAL_NUMBER_OF_INIT_COLUMNS
    var numberOfInitColumns: Int = INITIAL_NUMBER_OF_INIT_COLUMNS
        @Bindable get() {
            return numberOfInitColumnsTotal
        }
        set(value) {
            if (value > 0) {
                field = value
                numberOfInitColumnsTotal = value
            }
            notifyPropertyChanged(BR.numberOfInitColumns)
        }

    fun setInitColumnsPositionDecrease() {
        if (numberOfInitColumns > 0) {
            numberOfInitColumns -= 1
            notifyPropertyChanged(BR.numberOfInitColumns)
            //clearPositions() // TODO: should this be removed
        }
    }

    fun setInitColumnsPositionIncrease() {
        numberOfInitColumns += 1
        notifyPropertyChanged(BR.numberOfInitColumns)
        //clearPositions() // TODO: should this be removed
    }

    private var numberOfInitRowsTotal = INITIAL_NUMBER_OF_INIT_ROWS
    var numberOfInitRows: Int = INITIAL_NUMBER_OF_INIT_ROWS
        @Bindable get() {
            return numberOfInitRowsTotal
        }
        set(value) {
            if (value > 0) {
                field = value
                numberOfInitRowsTotal = value
            }
            notifyPropertyChanged(BR.numberOfInitRows)
        }

    fun setInitRowsPositionDecrease() {
        if (numberOfInitRows > 0) {
            numberOfInitRows -= 1
            notifyPropertyChanged(BR.numberOfInitRows)
            //clearPositions() // TODO: should this be removed
        }
    }

    fun setInitRowsPositionIncrease() {
        numberOfInitRows += 1
        notifyPropertyChanged(BR.numberOfInitRows)
        //clearPositions() // TODO: should this be removed
    }

    private var initDirection = INITIAL_DIRECTION
    var direction: String = INITIAL_DIRECTION
        @Bindable get() {
            return initDirection
        }
        set(value) {
            field = value
            initDirection = value
            notifyPropertyChanged(BR.direction)
        }

    fun setNavigationValue(value: String) {
        positionsObservable.value += value
    }

    private fun clearPositions() {
        positionsObservable.value = ""
    }
}