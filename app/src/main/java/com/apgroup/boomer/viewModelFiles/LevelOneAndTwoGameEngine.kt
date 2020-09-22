package com.apgroup.boomer.viewModelFiles

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LevelOneAndTwoGameEngine(level:Int,seconds: Long):ViewModel(){

    private var level = 0

    // ----------------------- Color Name to show up -----------------------------------
    private val _displayColorName = MutableLiveData<String>()
    val displayColorName:LiveData<String>
        get() = _displayColorName

    //------------------ Button Color Variable Declaration -----------------------------------
    private val _btn1Color=MutableLiveData<String>()
    val btn1Color:LiveData<String>
        get() = _btn1Color

    private val _btn2Color=MutableLiveData<String>()
    val btn2Color:LiveData<String>
        get() = _btn2Color

    private val _btn3Color=MutableLiveData<String>()
    val btn3Color:LiveData<String>
        get() = _btn3Color

    private val _btn4Color=MutableLiveData<String>()
    val btn4Color:LiveData<String>
        get() = _btn4Color

    private val _btn5Color=MutableLiveData<String>()
    val btn5Color:LiveData<String>
        get() = _btn5Color

    private val _btn6Color=MutableLiveData<String>()
    val btn6Color:LiveData<String>
        get() = _btn6Color

    //------------------- Button Text Variable Dec.-----------------------------
    private val _btn1Text=MutableLiveData<String>()
    val btn1Text:LiveData<String>
        get() = _btn1Text

    private val _btn2Text=MutableLiveData<String>()
    val btn2Text:LiveData<String>
        get() = _btn2Text

    private val _btn3Text=MutableLiveData<String>()
    val btn3Text:LiveData<String>
        get() = _btn3Text

    private val _btn4Text=MutableLiveData<String>()
    val btn4Text:LiveData<String>
        get() = _btn4Text

    private val _btn5Text=MutableLiveData<String>()
    val btn5Text:LiveData<String>
        get() = _btn5Text

    private val _btn6Text=MutableLiveData<String>()
    val btn6Text:LiveData<String>
        get() = _btn6Text

    //------------------- Button TextColor Variable Dec.-----------------------------
    private val _btn1TextColor=MutableLiveData<String>()
    val btn1TextColor:LiveData<String>
        get() = _btn1TextColor

    private val _btn2TextColor=MutableLiveData<String>()
    val btn2TextColor:LiveData<String>
        get() = _btn2TextColor

    private val _btn3TextColor=MutableLiveData<String>()
    val btn3TextColor:LiveData<String>
        get() = _btn3TextColor

    private val _btn4TextColor=MutableLiveData<String>()
    val btn4TextColor:LiveData<String>
        get() = _btn4TextColor

    private val _btn5TextColor=MutableLiveData<String>()
    val btn5TextColor:LiveData<String>
        get() = _btn5TextColor

    private val _btn6TextColor=MutableLiveData<String>()
    val btn6TextColor:LiveData<String>
        get() = _btn6TextColor

    //------------------- Timer Varaiable Dec. --------------------------------------
    private val _timer=MutableLiveData<Int>()
    val timer:LiveData<Int>
        get() = _timer

    private var countDown: CountDownTimer? = null

    private var seconds:Long=0

    private var correctBtn:Int = 0

    // --------------------- Score Counter ----------------------------------------
    private var _scoreCounter= MutableLiveData<Int>()
    val scoreCounter:LiveData<Int>
        get() = _scoreCounter

    private var score:Int=0

    //----------------------- Colors and Color Code Dec. ----------------------------------
    private val colorArray: ArrayList<String> = arrayListOf(
        "Red", "Orange", "Golden", "Yellow", "Green", "Blue", "Purple", "Violet",
        "Pink", "White", "Brown", "Cyan", "Navy", "Lavender", "Silver", "Magenta","Gray"
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
        this.level=level
        this.seconds=seconds

        when(level){
            1->{
                startTimer(this.seconds)
                LevelOneBrain()
            }
            2->{
                startTimer(this.seconds)
                LevelTwoBrain()
            }
            3->{
                startTimer(this.seconds)
                LevelThreeBrain()
            }
            4->{
                startTimer(this.seconds)
                LevelFourBrain()
            }
            else-> {
                Log.d("Level Error","No Level is selected")
            }
        }
    }

    // ------------------------- Timer Method ------------------------------
    private fun startTimer(seconds:Long){
        countDown=object:CountDownTimer(seconds,1000L){
            override fun onFinish() {
                score-=5
                _scoreCounter.value = score
                stopTimer()
            }
            override fun onTick(millisUntilFinished: Long) {
                _timer.value=millisUntilFinished.div(1000).toInt()
            }
        }.start()
    }

    private fun stopTimer(){
        countDown?.cancel()
    }

    // ------------------------ Level One Brain ---------------------------
    private fun LevelOneBrain(){
        colorArray.shuffle()
        colorArray.shuffle().toString()

        val totalBtnArray:ArrayList<Int> = arrayListOf(1,2)
        val colorText:ArrayList<String> = arrayListOf(colorArray[0],colorArray[1])
        val colorCode: ArrayList<String?> = arrayListOf(colorDictionary[colorText[0]],colorDictionary[colorText[1]])

        val tempColor:ArrayList<String> = arrayListOf(colorArray[2],colorArray[3])
        val textColor:ArrayList<String?> = arrayListOf(colorDictionary[tempColor[0]],colorDictionary[tempColor[1]])

        totalBtnArray.shuffle()

        _displayColorName.value= colorText.get(index = totalBtnArray[0] -1)

        GameEngine(colorText,colorCode,totalBtnArray,textColor)
    }

    //------------------------------ Level Two Brain ------------------------------------
    private fun LevelTwoBrain(){
        colorArray.shuffle()
        colorArray.shuffle().toString()

        val totalBtnArray:ArrayList<Int> = arrayListOf(1,2,3)
        val colorText:ArrayList<String> = arrayListOf(colorArray[0],colorArray[1],colorArray[2])
        val colorCode: ArrayList<String?> = arrayListOf(colorDictionary[colorText[0]],colorDictionary[colorText[1]],colorDictionary[colorText[2]])


        val tempColor:ArrayList<String> = arrayListOf(colorArray[5],colorArray[6],colorArray[7])
        val textColor:ArrayList<String?> = arrayListOf(colorDictionary[tempColor[0]],colorDictionary[tempColor[1]],colorDictionary[tempColor[2]])

        totalBtnArray.shuffle()
        _displayColorName.value= colorText.get(index = totalBtnArray.get(0)-1)

        GameEngine(colorText,colorCode,totalBtnArray,textColor)
    }

    //------------------------------ Level Three Brain ------------------------------------
    private fun LevelThreeBrain(){
        colorArray.shuffle()
        colorArray.shuffle().toString()

        val totalBtnArray:ArrayList<Int> = arrayListOf(1,2,3,4)
        val colorText:ArrayList<String> = arrayListOf(colorArray[0],colorArray[1],colorArray[2],
                                                        colorArray[3])
        val colorCode: ArrayList<String?> = arrayListOf(colorDictionary[colorText[0]],colorDictionary[colorText[1]]
                                                    ,colorDictionary[colorText[2]],colorDictionary[colorText[3]])


        val tempColor:ArrayList<String> = arrayListOf(colorArray[5],colorArray[6],colorArray[7],
            colorArray[8])
        val textColor:ArrayList<String?> = arrayListOf(colorDictionary[tempColor[0]],colorDictionary[tempColor[1]],
                                                        colorDictionary[tempColor[2]], colorDictionary[tempColor[3]])

        totalBtnArray.shuffle()
        _displayColorName.value= colorText.get(index = totalBtnArray.get(0)-1)

        GameEngine(colorText,colorCode,totalBtnArray,textColor)
    }

    //------------------------------ Level Four Brain ------------------------------------
    private fun LevelFourBrain(){
        colorArray.shuffle()
        colorArray.shuffle().toString()

        val totalBtnArray:ArrayList<Int> = arrayListOf(1,2,3,4,5,6)
        val colorText:ArrayList<String> = arrayListOf(colorArray[0],colorArray[1],colorArray[2],
                                                        colorArray[3],colorArray[4],colorArray[5])
        val colorCode: ArrayList<String?> = arrayListOf(colorDictionary[colorText[0]],colorDictionary[colorText[1]]
                                        ,colorDictionary[colorText[2]],colorDictionary[colorText[3]]
                                        ,colorDictionary[colorText[4]],colorDictionary[colorText[5]])



        val tempColor:ArrayList<String> = arrayListOf(colorArray[5],colorArray[6],colorArray[7],
                                                        colorArray[8],colorArray[9],colorArray[10])
        val textColor:ArrayList<String?> = arrayListOf(colorDictionary[tempColor[0]],colorDictionary[tempColor[1]],
                                                        colorDictionary[tempColor[2]], colorDictionary[tempColor[3]],
                                                        colorDictionary[tempColor[4]],colorDictionary[tempColor[5]])

        totalBtnArray.shuffle()
        _displayColorName.value= colorText.get(index = totalBtnArray.get(0)-1)

        GameEngine(colorText,colorCode,totalBtnArray,textColor)
    }

    private fun GameEngine(
        btnText:ArrayList<String>, btnColor: ArrayList<String?>, totalBtn:ArrayList<Int>,
        textColor: ArrayList<String?>
    ){

        if(1 in totalBtn){
            _btn1Color.value = btnColor[0]
            _btn1Text.value = btnText[0]
            _btn1TextColor.value = textColor[0]
        }

        if(2 in totalBtn){
            _btn2Color.value = btnColor[1]
            _btn2Text.value = btnText[1]
            _btn2TextColor.value = textColor[1]
        }

        if(3 in totalBtn){
            _btn3Color.value = btnColor[2]
            _btn3Text.value = btnText[2]
            _btn3TextColor.value = textColor[2]
        }

        if(4 in totalBtn){
            _btn4Color.value = btnColor[3]
            _btn4Text.value = btnText[3]
            _btn4TextColor.value = textColor[3]
        }

        if(5 in totalBtn){
            _btn5Color.value = btnColor[4]
            _btn5Text.value = btnText[4]
            _btn5TextColor.value = textColor[4]
        }

        if(6 in totalBtn){
            _btn6Color.value = btnColor[5]
            _btn6Text.value = btnText[5]
            _btn6TextColor.value = textColor[5]
        }

        correctBtn=totalBtn[0]

    }

    fun btnClicks(click:String)
    {
        if (click == correctBtn.toString()){
            score+=5
            _scoreCounter.value = score
            countDown?.cancel()
            startTimer(this.seconds)
        }
        else{
            score-=5
            _scoreCounter.value = score
            countDown?.cancel()
            startTimer(this.seconds)
        }

        when (this.level){
            1->LevelOneBrain()
            2->LevelTwoBrain()
            3->LevelThreeBrain()
            4->LevelFourBrain()
        }
    }
}