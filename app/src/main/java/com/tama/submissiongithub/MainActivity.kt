package com.tama.submissiongithub

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGitUser: RecyclerView
    private val list = ArrayList<GitUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGitUser = findViewById(R.id.rv_user)
        rvGitUser.setHasFixedSize(true)

        list.addAll(listGitUser)
        showRecylerList()
    }

    private val listGitUser:ArrayList<GitUser>
    get() {
        val dataName = resources.getStringArray(R.array.name)
        val dataDescription = resources.getStringArray(R.array.company)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataPhoto.recycle()
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataFullName = resources.getStringArray(R.array.name)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepositories = resources.getStringArray(R.array.repository)
        val listGitUser = ArrayList<GitUser>()
        for(i in dataName.indices){
            val users =GitUser(dataName[i], dataFullName[i], dataPhoto.getResourceId(i, -1), dataFollower[i], dataFollowing[i],dataDescription[i], dataCompany[i],dataLocation[i],dataRepositories[i])
            listGitUser.add(users)
        }
        return listGitUser
    }

    private fun showRecylerList(){
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvGitUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvGitUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvGitUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object: ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GitUser){
                showSelctedItem(data)

                val intentDetail = Intent(this@MainActivity, UserDetail::class.java)
                intentDetail.putExtra("DATA", data)
                startActivity(intentDetail)
            }
        })
    }

    private fun showSelctedItem(user: GitUser) {
        Toast.makeText(this, "Kamu memilih " + user.name, Toast.LENGTH_SHORT).show()
    }
}