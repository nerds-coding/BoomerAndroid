package com.apgroup.boomer.viewModelFiles

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LevelFiveAndSixGameEngine(level: Int, seconds: Long) : ViewModel() {

    private var level = 0
    private var nav: Boolean = false


    // ----------------------- Button Disable -------------------------------------
    private var _btn1Visible = MutableLiveData<Boolean>(false)
    val btn1Visible: LiveData<Boolean>
        get() = _btn1Visible

    private var _btn2Visible = MutableLiveData<Boolean>(false)
    val btn2Visible: LiveData<Boolean>
        get() = _btn2Visible

    private var _btn3Visible = MutableLiveData<Boolean>(false)
    val btn3Visible: LiveData<Boolean>
        get() = _btn3Visible

    private var _btn4Visible = MutableLiveData<Boolean>(false)
    val btn4Visible: LiveData<Boolean>
        get() = _btn4Visible

    private var _btn5Visible = MutableLiveData<Boolean>(false)
    val btn5Visible: LiveData<Boolean>
        get() = _btn5Visible

    private var _btn6Visible = MutableLiveData<Boolean>(false)
    val btn6Visible: LiveData<Boolean>
        get() = _btn6Visible

    private var _btn7Visible = MutableLiveData<Boolean>(false)
    val btn7Visible: LiveData<Boolean>
        get() = _btn7Visible

    private var _btn8Visible = MutableLiveData<Boolean>(false)
    val btn8Visible: LiveData<Boolean>
        get() = _btn8Visible

    // ----------------------- Color Name to show up -----------------------------------
    private val _displayColorName1 = MutableLiveData<String>()
    val displayColorName1: LiveData<String>
        get() = _displayColorName1

    private val _displayColorName2 = MutableLiveData<String>()
    val displayColorName2: LiveData<String>
        get() = _displayColorName2

    //------------------ Button Color Variable Declaration -----------------------------------
    private val _btn1Color = MutableLiveData<String>()
    val btn1Color: LiveData<String>
        get() = _btn1Color

    private val _btn2Color = MutableLiveData<String>()
    val btn2Color: LiveData<String>
        get() = _btn2Color

    private val _btn3Color = MutableLiveData<String>()
    val btn3Color: LiveData<String>
        get() = _btn3Color

    private val _btn4Color = MutableLiveData<String>()
    val btn4Color: LiveData<String>
        get() = _btn4Color

    private val _btn5Color = MutableLiveData<String>()
    val btn5Color: LiveData<String>
        get() = _btn5Color

    private val _btn6Color = MutableLiveData<String>()
    val btn6Color: LiveData<String>
        get() = _btn6Color

    private val _btn7Color = MutableLiveData<String>()
    val btn7Color: LiveData<String>
        get() = _btn7Color

    private val _btn8Color = MutableLiveData<String>()
    val btn8Color: LiveData<String>
        get() = _btn8Color

    //------------------- Button Text Variable Dec.-----------------------------
    private val _btn1Text = MutableLiveData<String>()
    val btn1Text: LiveData<String>
        get() = _btn1Text

    private val _btn2Text = MutableLiveData<String>()
    val btn2Text: LiveData<String>
        get() = _btn2Text

    private val _btn3Text = MutableLiveData<String>()
    val btn3Text: LiveData<String>
        get() = _btn3Text

    private val _btn4Text = MutableLiveData<String>()
    val btn4Text: LiveData<String>
        get() = _btn4Text

    private val _btn5Text = MutableLiveData<String>()
    val btn5Text: LiveData<String>
        get() = _btn5Text

    private val _btn6Text = MutableLiveData<String>()
    val btn6Text: LiveData<String>
        get() = _btn6Text

    private val _btn7Text = MutableLiveData<String>()
    val btn7Text: LiveData<String>
        get() = _btn7Text

    private val _btn8Text = MutableLiveData<String>()
    val btn8Text: LiveData<String>
        get() = _btn8Text

    //------------------- Button TextColor Variable Dec.-----------------------------
    private val _btn1TextColor = MutableLiveData<String>()
    val btn1TextColor: LiveData<String>
        get() = _btn1TextColor

    private val _btn2TextColor = MutableLiveData<String>()
    val btn2TextColor: LiveData<String>
        get() = _btn2TextColor

    private val _btn3TextColor = MutableLiveData<String>()
    val btn3TextColor: LiveData<String>
        get() = _btn3TextColor

    private val _btn4TextColor = MutableLiveData<String>()
    val btn4TextColor: LiveData<String>
        get() = _btn4TextColor

    private val _btn5TextColor = MutableLiveData<String>()
    val btn5TextColor: LiveData<String>
        get() = _btn5TextColor

    private val _btn6TextColor = MutableLiveData<String>()
    val btn6TextColor: LiveData<String>
        get() = _btn6TextColor

    private val _btn7TextColor = MutableLiveData<String>()
    val btn7TextColor: LiveData<String>
        get() = _btn7TextColor

    private val _btn8TextColor = MutableLiveData<String>()
    val btn8TextColor: LiveData<String>
        get() = _btn8TextColor

    //------------------- Timer Varaiable Dec. --------------------------------------
    private val _timer = MutableLiveData<Int>()
    val timer: LiveData<Int>
        get() = _timer

    private var countDown: CountDownTimer? = null
    private var seconds: Long = 0
    private var correctBtn: Array<Int> = arrayOf(0, 0)

    // --------------------- Score Counter ----------------------------------------
    private var _scoreCounter = MutableLiveData<Int>()
    val scoreCounter: LiveData<Int>
        get() = _scoreCounter

    private var score: Int = 0

    //----------------------- Colors and Color Code Dec. ----------------------------------
    private val colorArray: ArrayList<String> = arrayListOf(
        "Red", "Orange", "Golden", "Yellow", "Green", "Blue", "Purple", "Violet",
        "Pink", "White", "Brown", "Cyan", "Navy", "Lavender", "Silver", "Magenta", "Gray"
    )

    private val colorDictionary = mapOf(
        "Red" to "#FF0000",
        "Orange" to "#FFA500",
        "Golden" to "#FFD700",
        "Yellow" to "#FFFF00",
        "Green" to "#008000",
        "Blue" to "#0000FF",
        "Purple" to "#800080",
        "Violet" to "#EE82EE",
        "Pink" to "#FFB6C1",
        "White" to "#FFFFFF",
        "Black" to "#000000",
        "Brown" to "#8B4513",
        "Cyan" to "#00FFFF",
        "Navy" to "#000080",
        "Lavender" to "#E6E6FA",
        "Silver" to "#C0C0C0",
        "Magenta" to "#FF00FF",
        "Gray" to "#949494"
    )

    init {
        this.level = level
        this.seconds = seconds

        when (level) {
            5 -> {
                startTimer(this.seconds)
                LevelFiveBrain()
            }
            6 -> {
                startTimer(this.seconds)
                LevelSixBrain()
            }
            else -> {
                Log.d("Level Error", "No Level is selected")
            }
        }
    }

    private fun LevelSixBrain() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // ------------------------- Timer Method ------------------------------
    private fun startTimer(seconds: Long) {
        countDown = object : CountDownTimer(seconds, 1000L) {
            override fun onFinish() {
                score -= 5
                _scoreCounter.value = score
                stopTimer()
            }

            override fun onTick(millisUntilFinished: Long) {
                _timer.value = millisUntilFinished.div(1000).toInt()
            }
        }.start()
    }

    private fun stopTimer() {
        countDown?.cancel()
    }

    // ----------------------- LevelFiveBrain _---------------------------------
    fun LevelFiveBrain() {
        colorArray.shuffle()
        colorArray.shuffle().toString()

        val colorText: ArrayList<String> = arrayListOf(
            colorArray[0], colorArray[1], colorArray[2]
            , colorArray[3], colorArray[4], colorArray[5]
            , colorArray[6], colorArray[7]
        )
        val colorCode: ArrayList<String?> = arrayListOf(
            colorDictionary[colorText[0]], colorDictionary[colorText[1]],
            colorDictionary[colorText[2]], colorDictionary[colorText[3]],
            colorDictionary[colorText[4]], colorDictionary[colorText[5]],
            colorDictionary[colorText[6]], colorDictionary[colorText[7]]
        )

        val tempColor = colorText
        tempColor.shuffle().toString()
        val textColor: ArrayList<String?> = arrayListOf(
            colorDictionary[tempColor[0]], colorDictionary[tempColor[1]],
            colorDictionary[tempColor[2]], colorDictionary[tempColor[3]],
            colorDictionary[tempColor[4]], colorDictionary[tempColor[5]],
            colorDictionary[tempColor[6]], colorDictionary[tempColor[7]]
        )

        val totalBtn: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
        totalBtn.shuffle()
        _displayColorName1.value = colorText.get(index = totalBtn[0] - 1)
        _displayColorName2.value = colorText.get(index = totalBtn[1] - 1)

        GameEngine(colorText, colorCode, totalBtn, textColor)
    }


    private fun GameEngine(
        btnText: ArrayList<String>, btnColor: ArrayList<String?>, totalBtn: ArrayList<Int>,
        textColor: ArrayList<String?>
    ) {

        if (1 in totalBtn) {
            _btn1Color.value = btnColor[0]
            _btn1Text.value = btnText[0]
            _btn1TextColor.value = textColor[0]
        }

        if (2 in totalBtn) {
            _btn2Color.value = btnColor[1]
            _btn2Text.value = btnText[1]
            _btn2TextColor.value = textColor[1]
        }

        if (3 in totalBtn) {
            _btn3Color.value = btnColor[2]
            _btn3Text.value = btnText[2]
            _btn3TextColor.value = textColor[2]
        }

        if (4 in totalBtn) {
            _btn4Color.value = btnColor[3]
            _btn4Text.value = btnText[3]
            _btn4TextColor.value = textColor[3]
        }

        if (5 in totalBtn) {
            _btn5Color.value = btnColor[4]
            _btn5Text.value = btnText[4]
            _btn5TextColor.value = textColor[4]
        }

        if (6 in totalBtn) {
            _btn6Color.value = btnColor[5]
            _btn6Text.value = btnText[5]
            _btn6TextColor.value = textColor[5]
        }
        if (7 in totalBtn) {
            _btn7Color.value = btnColor[6]
            _btn7Text.value = btnText[6]
            _btn7TextColor.value = textColor[6]
        }
        if (8 in totalBtn) {
            _btn8Color.value = btnColor[7]
            _btn8Text.value = btnText[7]
            _btn8TextColor.value = textColor[7]
        }

        correctBtn[0] = totalBtn[0]
        correctBtn[1] = totalBtn[1]

    }

    fun btnClicks(click: String) {

        if ((correctBtn[0] == 1 || correctBtn[1] == 1) && click == "1") {
            _btn1Visible.value = true
        } else if ((correctBtn[0] == 2 || correctBtn[1] == 2) && click == "2") {
            _btn2Visible.value = true
        } else if ((correctBtn[0] == 3 || correctBtn[1] == 3) && click == "3") {
            _btn3Visible.value = true
        } else if ((correctBtn[0] == 4 || correctBtn[1] == 4) && click == "4") {
            _btn4Visible.value = true
        } else if ((correctBtn[0] == 5 || correctBtn[1] == 5) && click == "5") {
            _btn5Visible.value = true
        } else if ((correctBtn[0] == 6 || correctBtn[1] == 6) && click == "6") {
            _btn6Visible.value = true
        } else if ((correctBtn[0] == 7 || correctBtn[1] == 7) && click == "7") {
            _btn7Visible.value = true
        } else if ((correctBtn[0] == 8 || correctBtn[1] == 8) && click == "8") {
            _btn8Visible.value = true
        } else {
            nav = true
        }

        when (this.level) {

            5 -> {
                score += 5
                _scoreCounter.value = score
                countDown?.cancel()
                startTimer(this.seconds)
                LevelFiveBrain()
            }
            6 -> {
                score += 5
                _scoreCounter.value = score
                countDown?.cancel()
                startTimer(this.seconds)
                LevelSixBrain()
            }
        }
    }
}