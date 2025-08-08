package com.firemout.djcs

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firemout.djcs.R


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 声明并初始化点击计数器（初始值为0）
        var cishu :Int= 0
        // 定义点击事件处理函数
        fun handleClick(): Int {
            cishu += 1 // 每次调用计数器+1
            return cishu
        }
        val button1: Button = findViewById(R.id.button)
        // 设置按钮初始Y轴位置（垂直坐标）
        button1.y = 700f
        var text: TextView = findViewById(R.id.textView)
        button1.setOnClickListener {
            val newCount = handleClick() // 调用计数函数获取新计数
            text.text = newCount.toString() // 更新文本视图显示新计数
            // 当点击次数超过9999时，调整按钮Y轴位置（向下移动
            if (cishu > 9999) {
                button1.y = 1600f
            }

        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // 当点击"关于"菜单项时，显示应用信息提示
            R.id.about_item -> Toast.makeText(
                this, "Made by FireMount",
                Toast.LENGTH_LONG
            ).show()
        }
        return true
    }
}
