package com.fauzan.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fauzan.submission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvUser : RecyclerView
    private lateinit var mode : String
    private val list = ArrayList<DataUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rvUser = binding.rvUsers
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()

        mode = "Mode ListView"
        setTitleMode()
    }

    private val listUser: ArrayList<DataUser>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val listUser = ArrayList<DataUser>()
            for (i in dataName.indices) {
                val user = DataUser(
                    dataUsername[i],
                    dataName[i],
                    dataLocation[i],
                    dataRepository[i],
                    dataCompany[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataPhoto.getResourceId(i, -1))
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListUserAdapter(list, this)
        rvUser.adapter = listHeroAdapter
    }

    private fun showRecyclerGrid() {
        rvUser.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridUserAdapter(list, this)
        rvUser.adapter = gridHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when (selectedMode) {
            R.id.action_list -> {
                mode = "Mode ListView"
                showRecyclerList()
            }
            R.id.action_grid -> {
                mode = "Mode GridView"
                showRecyclerGrid()
            }
            R.id.action_about -> {
                val activity = Intent(this, AboutActivity::class.java)
                startActivity(activity)
            }
        }
        setTitleMode()
    }

    private fun setTitleMode(){
        binding.tvMode.text = mode
    }

}