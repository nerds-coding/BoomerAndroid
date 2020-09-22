package com.apgroup.boomer.modelFiles


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.apgroup.boomer.R
import com.apgroup.boomer.databinding.FragmentStartPageBinding

/**
 * A simple [Fragment] subclass.
 */
class Fragment_Start_Page : Fragment() {

    lateinit var binding:FragmentStartPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate<FragmentStartPageBinding>(inflater,
            R.layout.fragment_start__page,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.aboutBtn.setOnClickListener{
            findNavController().navigate(R.id.action_fragment_Start_Page_to_fragment_About_Page)
        }

        binding.startBtn.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Start_Page_to_levelSelection)
        }
    }



}
