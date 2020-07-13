package com.githubrepo.githubrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.githubrepo.githubrepos.databinding.FragmentRepoDetailBinding
import com.githubrepo.githubrepos.utilites.InjectorUtils
import com.githubrepo.githubrepos.viewmodels.RepoDetailViewModel

class RepoDetailFragment : Fragment() {

    private val args: RepoDetailFragmentArgs by navArgs()

    private val viewModel: RepoDetailViewModel by viewModels {
        InjectorUtils.provideRepoDetailViewModelFactory(requireActivity(), args.repoId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentRepoDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_repo_detail,
            container,
            false
        )

        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.viewModel = viewModel

        return binding.root
    }

}
