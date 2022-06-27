package com.zotreex.sample_project.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceFragmentCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.FragmentSearchBinding
import com.zotreex.sample_project.databinding.FragmentSettingsBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.domain.data.UiState
import javax.inject.Inject

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<SettingsViewModel> { viewModelFactory }
    private val binding: FragmentSettingsBinding by viewBinding()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener{
            viewModel.setTheme(1)
        }
    }
}