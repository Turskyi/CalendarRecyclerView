package io.github.turskyi.calendarrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import io.github.turskyi.calendarrecyclerview.horizontal.HorizontalCalendarActivity
import io.github.turskyi.calendarrecyclerview.simple.InfiniteRecyclerCalendarActivity
import io.github.turskyi.calendarrecyclerview.simple.SimpleRecyclerCalendarActivity
import io.github.turskyi.calendarrecyclerview.vertical.VerticalCalendarActivity
import io.github.turskyi.calendarrecyclerview.viewpager.ViewPagerCalendarActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutWeekCalendar: LinearLayout = findViewById(R.id.layoutWeekCalendarActivity)
        layoutWeekCalendar.setOnClickListener {
            val intent = Intent(this@MainActivity, HorizontalCalendarActivity::class.java)
            startActivity(intent)
        }

        val layoutMonthCalendar: LinearLayout = findViewById(R.id.layoutMonthCalendarActivity)
        layoutMonthCalendar.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, VerticalCalendarActivity::class.java)
            startActivity(intent)
        }

        val layoutPageCalendar: LinearLayout = findViewById(R.id.layoutPageCalendarActivity)
        layoutPageCalendar.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, ViewPagerCalendarActivity::class.java)
            startActivity(intent)
        }

        val layoutSimpleCalendar: LinearLayout = findViewById(R.id.layoutSimpleCalendarActivity)
        layoutSimpleCalendar.setOnClickListener {
            val intent =
                Intent(this@MainActivity, SimpleRecyclerCalendarActivity::class.java)
            startActivity(intent)
        }

        val layoutInfiniteCalendar: LinearLayout =
            findViewById(R.id.layoutInfiniteCalendarActivity)
        layoutInfiniteCalendar.setOnClickListener {
            val intent =
                Intent(this@MainActivity, InfiniteRecyclerCalendarActivity::class.java)
            startActivity(intent)
        }
    }
}
