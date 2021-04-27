package com.example.testandroidx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.testandroidx.testLiveData.MyViewModel
import kotlinx.android.synthetic.main.test_fragment.*

class TestFragment : Fragment() {

    private val model: MyViewModel by activityViewModels() //부모 액티비티 뷰모델 사용

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.test_fragment,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** 부모 뷰모델 데이터 변경 감지 */
        model.getUsers().observe(requireActivity(), Observer {
            var str = it.toString()
            txt.text = str
        })

    }
}