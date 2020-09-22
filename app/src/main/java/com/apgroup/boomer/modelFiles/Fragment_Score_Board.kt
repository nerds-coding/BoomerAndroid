package com.apgroup.boomer.modelFiles


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.apgroup.boomer.R
import com.apgroup.boomer.databinding.FragmentScoreBoardBinding

/**
 * A simple [Fragment] subclass.
 */
class Fragment_Score_Board : Fragment(){

    private val args:Fragment_Score_BoardArgs by navArgs()
    private lateinit var binding:FragmentScoreBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_score_board,container,false)
        binding.lifecycleOwner = this

        binding.points.text = args.score.toString()
        binding.remark.text = args.remark

        if (args.score <=20){
            binding.nextLevel.isVisible = false
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextLevel.setOnClickListener {
            val action = Fragment_Score_BoardDirections.actionFragmentScoreBoardToLevelSelection()
            findNavController().navigate(action)
        }

        binding.retryBtn.setOnClickListener {
            val action = Fragment_Score_BoardDirections.actionFragmentScoreBoardToLevelSelection()
            findNavController().navigate(action)
        }

    }
// TODO call the room here for unlocking the next level and store the score


}
