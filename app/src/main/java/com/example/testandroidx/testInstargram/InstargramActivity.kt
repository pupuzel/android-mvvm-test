package com.example.testandroidx.testInstargram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testandroidx.R
import com.example.testandroidx.databinding.InstargramActivityBinding


class InstargramActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding :InstargramActivityBinding = DataBindingUtil.setContentView(this, R.layout.instargram_activity)
        val viewmodel = ViewModelProvider(this).get(InstargramViewModel::class.java)

        binding.viewmodel = viewmodel
        binding.lifecycleOwner =  this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        var userList = ArrayList<UserVo>()
        userList.add(UserVo("e0eun_qt", "족영은"))
        userList.add(UserVo("deep_shining_", "적성훈"))
        userList.add(UserVo("g_yyuu_", "족석준"))
        userList.add(UserVo("seo._.6", "족규민"))
        userList.add(UserVo("sun_nowplaying", "족서준"))
        userList.add(UserVo("wonbin622", "족명호"))
        userList.add(UserVo("yang.0626", "족혜선"))
        userList.add(UserVo("galpos3_", "족하형"))
        binding.recyclerview.adapter = UserAdapter(this,userList,viewmodel)

        viewmodel.counter.observe(this, Observer {
            var str = "팔로잉 ${it.toString()}명"
            viewmodel.following.value = str
        })
    }

}