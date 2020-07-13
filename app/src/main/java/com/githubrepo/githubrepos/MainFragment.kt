package com.githubrepo.githubrepos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.githubrepo.githubrepos.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        binding.searchButton.setOnClickListener {
            it.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToRepoFragment())
        }

        binding.setLifecycleOwner(viewLifecycleOwner)

        return binding.root
    }

}
