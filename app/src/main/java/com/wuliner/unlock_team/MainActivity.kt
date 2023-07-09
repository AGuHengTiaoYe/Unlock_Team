package com.wuliner.unlock_team

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.slipunlock.Model
import com.example.slipunlock.Presenter
import com.wuliner.unlock_team.databinding.ActivityMainBinding

class MainActivity(

) : AppCompatActivity(),ISlipUnlock {

    override lateinit var binding: ActivityMainBinding
    //保存presenter对象
    val presenter = Presenter(this)
    //提示框
    lateinit var alertTitle: TextView



    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        //初始化数据
        presenter.initData()


        //给容器添加触摸事件
        binding.container.setOnTouchListener { v, event ->
            presenter.touchEvent(event, binding)
            true
        }
    }


    override fun changeColor(model: Model, ifRight: Boolean) {
        if (!ifRight){
            model.imageView.setImageResource(model.wrongImage)
        }else{
            model.imageView.setImageResource(model.rightPicture)
        }
    }

    override fun changeWord(msg: String) {
        alertTitle.text = msg
    }

    override fun changeVisiblity(imageView: ImageView, isVisible: Boolean) {
        if (isVisible){
            imageView.visibility = View.VISIBLE
        }else{
            imageView.visibility = View.INVISIBLE
        }
    }
}