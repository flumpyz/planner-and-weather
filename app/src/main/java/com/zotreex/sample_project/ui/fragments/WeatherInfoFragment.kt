package com.zotreex.sample_project.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.FragmentWeatherInfoBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.ui.viewModels.WeatherInfoViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class WeatherInfoFragment : Fragment(R.layout.fragment_weather_info) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<WeatherInfoViewModel> { viewModelFactory }
    private val binding: FragmentWeatherInfoBinding by viewBinding()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datetime = arguments?.getString("datetime") ?: "2022-01-01"
        viewModel.getWeatherInfo(datetime)

        viewModel.liveData.observe(viewLifecycleOwner) {
            it ?: return@observe
            if (it is UiState.Loading)
                binding.progress.visibility = View.VISIBLE
            else
                binding.progress.visibility = View.GONE

            if(it is UiState.Success) {
                val currentDate = LocalDate.parse(it.value.daysInfo[0].datetime, DateTimeFormatter.ISO_DATE)
                val formatter = DateTimeFormatter.ofPattern("EEEE")
                val currentFormattedDate = currentDate.format(formatter)

                binding.day.text = currentFormattedDate
                binding.date.text = it.value.daysInfo[0].datetime
                binding.temperatureValue.text = it.value.daysInfo[0].temperature.toString()
                binding.feelsLikeValue.text = it.value.daysInfo[0].feelsLike.toString()
                binding.humidityValue.text = it.value.daysInfo[0].humidity.toString()
                binding.windSpeedValue.text = it.value.daysInfo[0].windSpeed.toString()
                binding.pressureValue.text = it.value.daysInfo[0].pressure.toString()
                binding.conditionsValue.text = it.value.daysInfo[0].conditions
            }

        }
    }

}