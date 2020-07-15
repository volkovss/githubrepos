package com.githubrepo.githubrepos.ui

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.NavHostFragment
import com.githubrepo.githubrepos.R
import com.githubrepo.githubrepos.RepoFragmentDirections


class RepoDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.dialog_text)
                .setPositiveButton(R.string.ok
                ) { _, _ ->
                    val direction = RepoFragmentDirections.actionRepoFragmentToMainFragment()
                    NavHostFragment.findNavController(this).navigate(direction)
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}