package com.apgroup.boomer.viewFiles


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.apgroup.boomer.R
import com.apgroup.boomer.databinding.FragmentLevelFiveBinding
import com.apgroup.boomer.viewModelFiles.LevelFiveAndSixGameEngine
import com.apgroup.boomer.viewModelFiles.ViewModelFiveAndSix

/**
 * A simple [Fragment] subclass.
 */
class Fragment_Level_Five : Fragment(),View.OnClickListener {

    private lateinit var binding:FragmentLevelFiveBinding
    private lateinit var viewModel:LevelFiveAndSixGameEngine

    private var counter=0
    private var remark=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_level_five,container,false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders
            .of(this,ViewModelFiveAndSix(5,5000L))
            .get(LevelFiveAndSixGameEngine::class.java)
        binding.levelFive = viewModel

        binding.studentClass = Student(false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        counter+=1

        if(counter==11){
            val score= viewModel.scoreCounter.value

            if(score!! <= 20){
                remark = "Nice Try"
            }
            else if( score <= 40){
                remark = "Very Good"
            }
            else if(score >40 ){
                remark = "Excellent"
            }

            val action=Fragment_Level_FiveDirections
                .actionFragmentLevelFiveToFragmentScoreBoard(score,remark)

            findNavController().navigate(action)
        }
        else {
            var btn = v!!.tag
            btn = btn.toString()
            //viewModel.btnClicks(btn)
        }
    }
}



data class Student(val Visible:Boolean)


