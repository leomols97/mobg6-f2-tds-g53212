package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

// SleepNightAdapter.ViewHolder vient de la classe que j'ai créée DANS la classe SleepNightAdapter
class SleepNightAdapter(val clickListener: SleepNightListener): ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {

    /**
     * DiffUtil

    RecyclerView has a class called DiffUtil which is for calculating the differences between two lists.
    DiffUtil has a class called ItemCallBack that you extend in order to figure out the difference between two lists.
    In the ItemCallback class, you must override the areItemsTheSame() and areContentsTheSame() methods.
    ListAdapter

    To get some list management for free,
    you can use the ListAdapter class instead of RecyclerView.Adapter.
    However, if you use ListAdapter you have to write your own adapter for other layouts,
    which is why this codelab shows you how to do it.
    To open the intention menu in Android Studio,
    place the cursor on any item of code and press Alt+Enter.
    This menu is particularly helpful for refactoring code and creating stubs for implementing methods.
    The menu is context-sensitive, so you need to place the cursor exactly to get the correct menu.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return from(parent)
    }

    class ViewHolder constructor(val binding: ListItemSleepNightBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: SleepNight, clickListener: SleepNightListener) {
            binding.sleep = item
            binding.clickListener = clickListener
            /* Pour de l'optimisation du biiniding qui dépend de la variable 'sleep'
                Cela permet aussi de gagner du temps sur le dimensionnage des fepêtres
             */
            binding.executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =
                ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}


class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }
}

class SleepNightListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(night: SleepNight) = clickListener(night.nightId)
}