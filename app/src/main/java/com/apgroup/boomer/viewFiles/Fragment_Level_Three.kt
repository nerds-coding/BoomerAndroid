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
import com.apgroup.boomer.databinding.FragmentLevelThreeBinding
import com.apgroup.boomer.viewModelFiles.LevelOneAndTwoGameEngine
import com.apgroup.boomer.viewModelFiles.ViewModelFactoryFile

/**
 * A simple [Fragment] subclass.
 */
class Fragment_Level_Three : Fragment(), View.OnClickListener{

    private lateinit var binding: FragmentLevelThreeBinding
    private lateinit var viewModel: LevelOneAndTwoGameEngine
    private var counter=0
    private lateinit var remark:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_level_three,container,false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders
            .of(this, ViewModelFactoryFile(3,4000L))
            .get(LevelOneAndTwoGameEngine::class.java)
        binding.levelThree = viewModel

        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)


        return binding.root
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
            val action= Fragment_Level_ThreeDirections
                .actionFragmentLevelThreeToFragmentScoreBoard(score,remark)
            findNavController().navigate(action)

        }
        else {
            var btn = v!!.tag
            btn = btn.toString()
            viewModel.btnClicks(btn)
        }
    }

}
