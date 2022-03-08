package dk.quan.devoteamrobot.data

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import dk.quan.devoteamrobot.BR
import dk.quan.devoteamrobot.util.ObservableViewModel

const val INITIAL_NUMBER_OF_ROOM_COLUMNS = 5
const val INITIAL_NUMBER_OF_ROOM_ROWS = 5
const val INITIAL_NUMBER_OF_INIT_COLUMNS = 3
const val INITIAL_NUMBER_OF_INIT_ROWS = 3
const val INITIAL_DIRECTION = "N"

class RobotViewModel : ObservableViewModel() {

    val positionsObservable: MutableLiveData<String> = MutableLiveData("")

    private var numberOfRoomColumnsTotal = INITIAL_NUMBER_OF_ROOM_COLUMNS
    var numberOfRoomColumns: Int = INITIAL_NUMBER_OF_ROOM_COLUMNS
        @Bindable get() {
            return numberOfRoomColumnsTotal
        }
        set(value) {
            if (value > 0) {
                field = value
                numberOfRoomColumnsTotal = value
            }
            notifyPropertyChanged(BR.numberOfRoomColumns)
            clearPositions()
        }

    fun setRoomColumnsDecrease() {
        if (numberOfRoomColumns > 0) {
            numberOfRoomColumns -= 1
            notifyPropertyChanged(BR.numberOfRoomColumns)
        }
    }

    fun setRoomColumnsIncrease() {
        numberOfRoomColumns += 1
        notifyPropertyChanged(BR.numberOfRoomColumns)
    }

    private var numberOfRoomRowsTotal = INITIAL_NUMBER_OF_ROOM_ROWS
    var numberOfRoomRows: Int = INITIAL_NUMBER_OF_ROOM_ROWS
        @Bindable get() {
            return numberOfRoomRowsTotal
        }
        set(value) {
            if (value > 0) {
                field = value
                numberOfRoomRowsTotal = value
            }
            notifyPropertyChanged(BR.numberOfRoomRows)
            clearPositions()
        }

    fun setRoomRowsDecrease() {
        if (numberOfRoomRows > 0) {
            numberOfRoomRows -= 1
            notifyPropertyChanged(BR.numberOfRoomRows)
        }
    }

    fun setRoomRowsIncrease() {
        numberOfRoomRows += 1
        notifyPropertyChanged(BR.numberOfRoomRows)
    }

    private var numberOfInitColumnsTotal = INITIAL_NUMBER_OF_INIT_COLUMNS
    var numberOfInitColumns: Int = INITIAL_NUMBER_OF_INIT_COLUMNS
        @Bindable get() {
            return numberOfInitColumnsTotal
        }
        set(value) {
            if (value in 0..numberOfRoomColumns) {
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
            if (value in 0..numberOfRoomRows) {
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
        if (canRobotBeMoved(value)) {
            positionsObservable.value += value
        }
    }

    private fun clearPositions() {
        positionsObservable.value = ""
    }

    private fun canRobotBeMoved(value: String): Boolean {
        var returnValue = true
        when (value) {
            "F" -> {
                returnValue = updatePosition()
            }
            "L", "R" -> {
                updateDirection(value)
            }
        }
        return returnValue
    }

    private fun updateDirection(value: String) {
        when (direction) {
            "N" -> {
                direction = if (value == "L") {
                    "W"
                } else {
                    "E"
                }
            }
            "S" -> {
                direction = if (value == "L") {
                    "E"
                } else {
                    "W"
                }
            }
            "E" -> {
                direction = if (value == "L") {
                    "N"
                } else {
                    "S"
                }
            }
            "W" -> {
                direction = if (value == "L") {
                    "S"
                } else {
                    "N"
                }
            }
        }
    }

    private fun updatePosition() : Boolean {
        var returnValue = true
        when (direction) {
            "N" -> {
                if (numberOfInitRows > 0) {
                    numberOfInitRows--
                } else {
                    returnValue = false
                }
            }
            "S" -> {
                if (numberOfInitRows < numberOfRoomRows) {
                    numberOfInitRows++
                } else {
                    returnValue = false
                }
            }
            "E" -> {
                if (numberOfInitColumns < numberOfRoomColumns) {
                    numberOfInitColumns++
                } else {
                    returnValue = false
                }
            }
            "W" -> {
                if (numberOfInitColumns > 0) {
                    numberOfInitColumns--
                } else {
                    returnValue = false
                }
            }
        }
        return returnValue
    }
}