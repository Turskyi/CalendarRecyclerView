package io.github.turskyi.calendarrecyclerview.horizontal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import com.tejpratapsingh.recyclercalendar.model.RecyclerCalendarConfiguration
import com.tejpratapsingh.recyclercalendar.utilities.CalendarUtils
import io.github.turskyi.calendarrecyclerview.R
import kotlinx.android.synthetic.main.activity_horizontal_calendar.*
import java.util.*

class HorizontalCalendarActivity : AppCompatActivity(R.layout.activity_horizontal_calendar) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val date = Date()
        date.time = System.currentTimeMillis()

        val startCal = Calendar.getInstance()

        val endCal = Calendar.getInstance()
        endCal.time = date
        endCal.add(Calendar.MONTH, 3)

        val configuration =
            RecyclerCalendarConfiguration(
                calenderViewType = RecyclerCalendarConfiguration.CalenderViewType.HORIZONTAL,
                calendarLocale = Locale.getDefault(),
                includeMonthHeader = false
            )

        textViewSelectedDate.text =
            CalendarUtils.dateStringFromFormat(
                locale = configuration.calendarLocale,
                date = date,
                format = CalendarUtils.LONG_DATE_FORMAT
            ) ?: ""

        val calendarAdapterHorizontal =
            HorizontalRecyclerCalendarAdapter(
                startDate = startCal.time,
                endDate = endCal.time,
                configuration = configuration
            )

        calendarAdapterHorizontal.onMonthClickListener = {
            Toast.makeText(this, "${it.date}", Toast.LENGTH_SHORT).show()
                textViewSelectedDate.text =
                    CalendarUtils.dateStringFromFormat(
                        locale = configuration.calendarLocale,
                        date = it.date,
                        format = CalendarUtils.LONG_DATE_FORMAT
                    ) ?: ""
        }

        calendarRecyclerView.adapter = calendarAdapterHorizontal

        val snapHelper = PagerSnapHelper() // Or LinearSnapHelper
        snapHelper.attachToRecyclerView(calendarRecyclerView)
    }
}
