package com.githubrepo.githubrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.githubrepo.githubrepos.data.GitHubRepo
import com.githubrepo.githubrepos.databinding.FragmentRepoListBinding
import com.githubrepo.githubrepos.databinding.RepoItemBinding
import com.githubrepo.githubrepos.utilites.InjectorUtils
import com.githubrepo.githubrepos.viewmodels.RepoListViewModel


class RepoFragment : Fragment() {

    private val viewModel: RepoListViewModel by viewModels {
        InjectorUtils.provideRepoListViewModelFactory(requireContext())
    }


    private var viewModelAdapter: RepoAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.repos.observe(viewLifecycleOwner, Observer<List<GitHubRepo>> { repos ->
            repos?.apply {
                viewModelAdapter?.repos = repos
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRepoListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_repo_list,
            container,
            false
        )

        binding.setLifecycleOwner(viewLifecycleOwner)

        binding.viewModel = viewModel

        viewModelAdapter = RepoAdapter(RepoClick {
            val direction = RepoFragmentDirections.actionRepoFragmentToRepoDetailFragment()
            NavHostFragment.findNavController(this).navigate(direction)
        })

        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        return binding.root
    }


}

class RepoClick(val block: (GitHubRepo) -> Unit) {
    fun onClick(repo: GitHubRepo) = block(repo)
}


class RepoAdapter(val callback: RepoClick) : RecyclerView.Adapter<RepoViewHolder>() {

    var repos: List<GitHubRepo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val withDataBinding: RepoItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            RepoViewHolder.LAYOUT,
            parent,
            false
        )
        return RepoViewHolder(withDataBinding)
    }

    override fun getItemCount() = repos.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.repo = repos[position]
            it.repoCallback = callback
        }
    }
}

class RepoViewHolder(val viewDataBinding: RepoItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.repo_item
    }
}
