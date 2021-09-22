package com.mitm.android.cryptodozen.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mitm.android.cryptodozen.common.Constants
import com.mitm.android.cryptodozen.databinding.FragmentHomeBinding
import com.mitm.android.cryptodozen.domain.repository.CoinRepository
import com.mitm.android.cryptodozen.presentation.adapters.CoinsRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @Inject
    lateinit var repository: CoinRepository


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        Constants("HomeFragment create")

        val recycler = binding.recyclerHome
        val adapter = CoinsRecyclerAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        binding.button.setOnClickListener {
            homeViewModel.getDetail()
        }

        homeViewModel.coinList.observe(viewLifecycleOwner, Observer {
            homeViewModel.coinList.value?.let { it1 -> adapter.loadCoins(it1) }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}