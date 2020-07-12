package com.githubrepo.githubrepos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.githubrepo.githubrepos.databinding.FragmentRepoDetailBinding

class RepoDetailFragment : Fragment() {


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

        return binding.root
    }

}
