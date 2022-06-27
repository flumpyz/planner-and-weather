package com.zotreex.sample_project.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.SampleItemBinding
import com.zotreex.sample_project.domain.data.SampleItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SampleListAdapter() :
    ListAdapter<SampleItem, SampleListAdapter.ViewHolder>(SampleDiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sampleItem: SampleItem = currentList[position]
        holder.bind(sampleItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SampleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: SampleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SampleItem) {
            val currentDate = LocalDate.parse(item.datetime, DateTimeFormatter.ISO_DATE)
            val formatter = DateTimeFormatter.ofPattern("EEEE")
            val currentFormattedDate = currentDate.format(formatter)

            binding.date.text = currentFormattedDate
            binding.minTemperature.text = item.minTemperature.toString()
            binding.maxTemperature.text = item.maxTemperature.toString()
            binding.datetime.text = currentDate.toString()

            binding.button.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(
                        R.id.action_sampleFragment_to_weatherInfoFragment,
                        bundleOf(Pair("datetime", item.datetime))
                    )

            }
        }
    }

}

class SampleDiffCallBack : DiffUtil.ItemCallback<SampleItem>() {
    override fun areItemsTheSame(oldItem: SampleItem, newItem: SampleItem): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: SampleItem, newItem: SampleItem): Boolean =
        oldItem == newItem

}

