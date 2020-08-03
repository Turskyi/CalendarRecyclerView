package io.github.turskyi.calendarrecyclerview.horizontal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tejpratapsingh.recyclercalendar.adapter.RecyclerCalendarBaseAdapter
import com.tejpratapsingh.recyclercalendar.model.RecyclerCalendarConfiguration
import com.tejpratapsingh.recyclercalendar.model.RecyclerCalenderViewItem
import com.tejpratapsingh.recyclercalendar.utilities.CalendarUtils
import io.github.turskyi.calendarrecyclerview.R
import java.util.*

class HorizontalRecyclerCalendarAdapter(
    startDate: Date,
    endDate: Date,
    private val configuration: RecyclerCalendarConfiguration
) : RecyclerCalendarBaseAdapter(startDate, endDate, configuration) {

    var onMonthClickListener: ((item: RecyclerCalenderViewItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_calendar_horizontal, parent, false)
        return MonthCalendarViewHolder(
            view
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        calendarItem: RecyclerCalenderViewItem
    ) {
        val monthViewHolder: MonthCalendarViewHolder = holder as MonthCalendarViewHolder
        val context: Context = monthViewHolder.itemView.context
        monthViewHolder.itemView.visibility = View.VISIBLE

        monthViewHolder.tvMonth.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.colorBlack
            )
        )
        monthViewHolder.tvYear.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.colorBlack
            )
        )
        
        val selectedCalendar = Calendar.getInstance()
        selectedCalendar.time = calendarItem.date

        val month: String = CalendarUtils.dateStringFromFormat(
            locale = configuration.calendarLocale,
            date = selectedCalendar.time,
            format = CalendarUtils.DISPLAY_MONTH_FORMAT
        ) ?: ""
        val year = selectedCalendar[Calendar.YEAR].toLong()

        monthViewHolder.tvMonth.text = month
        monthViewHolder.tvYear.text = year.toString()
    }

    inner class MonthCalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMonth: TextView = itemView.findViewById(R.id.textCalenderItemHorizontalDay)
        val tvYear: TextView = itemView.findViewById(R.id.textCalenderItemHorizontalDate)

        init {
            itemView.setOnClickListener {
                onMonthClickListener?.invoke(getItem(bindingAdapterPosition) as RecyclerCalenderViewItem)
            }
        }
    }
}