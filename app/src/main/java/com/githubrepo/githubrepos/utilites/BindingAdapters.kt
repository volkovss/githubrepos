package com.githubrepo.githubrepos.utilites

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.githubrepo.githubrepos.R
import com.githubrepo.githubrepos.data.GitHubRepo
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("goneIfNotNull")
fun goneIfNotNull(view: View, it: List<GitHubRepo>?) {
    view.visibility = View.INVISIBLE
    if (it == null) {
        view.visibility = View.VISIBLE
    } else {
        if (it.isEmpty()) view.visibility = View.VISIBLE
        else view.visibility = View.INVISIBLE
    }
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("dateForm")
fun dateForm(view: TextView, date: Date?) {
    val dateFormat = SimpleDateFormat("d MMM, yyyy")
    view.text = dateFormat.format(date?.time)
}

@BindingAdapter("boolForm")
fun boolForm(view: TextView, flag: Boolean?) {
    if (flag == null) view.text = ""
    else {
        if(flag) view.text = R.string.yes.toString()
        else view.text = R.string.no.toString()
    }
}

