package com.tama.submissiongithub

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitUser(
    var name: String,
    var description: String,
    var photo: Int,
    var follower: String,
    var following: String,
    var company: String,
    var location: String,
    var fullname: String,
    var repositories: String,
) : Parcelable
