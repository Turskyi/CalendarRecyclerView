package io.github.turskyi.calendarrecyclerview.viewpager

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import io.github.turskyi.calendarrecyclerview.R
import io.github.turskyi.calendarrecyclerview.viewpager.ui.main.SectionsPagerAdapter

class ViewPagerCalendarActivity : AppCompatActivity(R.layout.activity_view_pager_calendar) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val config = resources.configuration
        if (config.layoutDirection == View.LAYOUT_DIRECTION_RTL) {
            /* showAlertMsg("LTR") */
            tabs.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }
    }
}