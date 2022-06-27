package com.zotreex.sample_project.ui

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.FragmentSearchBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.ui.adapters.SampleListAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class SearchFragment : Fragment(R.layout.fragment_search) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<SearchViewModel> { viewModelFactory }
    private val binding: FragmentSearchBinding by viewBinding()

    private val adapter = SampleListAdapter()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sampleAdapter.adapter = adapter

        binding.searchField.setOnClickListener{
            viewModel.search(binding.searchField.text.toString())
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            it ?: return@observe
            if (it is UiState.Loading)
            else
                binding.progress.visibility = View.GONE

            if(it is UiState.Success) {
                binding.sampleAdapter.visibility = View.VISIBLE
                binding.cityName.visibility = View.VISIBLE
                binding.errorMsg.visibility = View.GONE

                binding.cityName.text = it.value.cityName
                adapter.submitList(it.value.daysInfo)
            }

            if(it is UiState.Error) {
                binding.sampleAdapter.visibility = View.GONE
                binding.cityName.visibility = View.GONE
                binding.errorMsg.visibility = View.VISIBLE

                binding.errorMsg.text = it.msg
            }

        }
    }

}