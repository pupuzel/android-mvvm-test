package com.example.testandroidx

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.testandroidx.testLiveData.MyViewModel
import com.example.testandroidx.testkoin.SchoolService
import com.example.testandroidx.testkoin.StudentController
import kotlinx.android.synthetic.main.test_activity.*
import org.koin.android.ext.android.inject

class TestActivity : FragmentActivity() {
    
    /** Koin으로 등록한 의존성 주입*/
    private val schoolService : SchoolService by inject()
    private val studentController : StudentController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)

        /** Test Koin */
        schoolService.newName("족족몬")
        studentController.print()


        /** Test ViewModel & LiveData */
        //val model = ViewModelProvider(this).get(MyViewModel::class.java)
        val model : MyViewModel by viewModels()
        edit1.addTextChangedListener(onTextChanged = { charSequence: CharSequence?, i: Int, i1: Int, i2: Int ->
            run {
                var str = charSequence.toString()
                model.setUsers(str)
            }
        })

        model.getUsers().observe(this, Observer {
            txt1.text = it.toString()
        })

        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout,
            TestFragment()
        ).commit()



        /** Test Room , 무조건 비동기로 사용해야하며 메인 쓰레드에서 사용시 Exception 발생 */
/*
            AppDatabase.getInstance(this).userDao().getOne("3")
                .subscribeOn(Schedulers.computation())
                .unsubscribeOn(Schedulers.computation())
                .subscribe({
                    Log.d("족",it.toString())
                },{
                    Log.d("족",it.message)
                })
            */

/*
            Observable.just("")
                .subscribeOn(Schedulers.computation())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe({
                    AppDatabase.getInstance(this).userDao().insertAll(userVo)

                    var list = AppDatabase.getInstance(this).userDao().getAll()
                    Log.d("족족",list.toString())
                })
 */



    }


}





