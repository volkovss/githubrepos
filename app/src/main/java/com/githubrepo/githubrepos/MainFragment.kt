package com.githubrepo.githubrepos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.githubrepo.githubrepos.databinding.FragmentMainBinding
import com.githubrepo.githubrepos.utilites.InjectorUtils
import com.githubrepo.githubrepos.viewmodels.RepoMainViewModel


class MainFragment : Fragment() {

    private val viewModel: RepoMainViewModel by viewModels {
        InjectorUtils.provideMainViewModelFactory(requireActivity())
    }

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

        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.viewModel = viewModel

        binding.searchButton.setOnClickListener {
            it.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToRepoFragment(viewModel.userName.value ?: ""))
        }

        binding.clearButton.setOnClickListener {
            viewModel.clearCache()
        }

        return binding.root
    }

}
