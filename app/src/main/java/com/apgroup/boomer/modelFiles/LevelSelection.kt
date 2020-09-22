package com.apgroup.boomer.modelFiles


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.apgroup.boomer.R
import com.apgroup.boomer.databinding.FragmentLevelSelectionBinding
import com.apgroup.boomer.viewFiles.Fragment_Level_One
import kotlinx.android.synthetic.main.fragment_level_selection.*

class LevelSelection : Fragment() {

    lateinit var binding: FragmentLevelSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_level_selection,container,false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        level_one.setOnClickListener {
            val action=LevelSelectionDirections.actionLevelSelectionToFragmentLevelOne(1)
            findNavController().navigate(action)
        }
        level_two.setOnClickListener {
            val action=LevelSelectionDirections.actionLevelSelectionToFragmentLevelTwo(2)
            findNavController().navigate(action)
        }
        level_three.setOnClickListener {
            val action=LevelSelectionDirections.actionLevelSelectionToFragmentLevelThree(3)
            findNavController().navigate(action)
        }
        level_four.setOnClickListener {
            val action=LevelSelectionDirections.actionLevelSelectionToFragmentLevelFour(4)
            findNavController().navigate(action)
        }

        level_five.setOnClickListener {
            val action=LevelSelectionDirections.actionLevelSelectionToFragmentLevelFive(5)
            findNavController().navigate(action)
        }
    }

}
