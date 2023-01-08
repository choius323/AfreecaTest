package com.choius323.afreecatest.ui.broad

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.choius323.afreecatest.KEY_CATEGORY
import com.choius323.afreecatest.databinding.FragmentBroadListBinding
import com.choius323.afreecatest.ui.broad.adapter.BroadRecyclerViewAdapter
import com.choius323.afreecatest.ui.detail.BroadDetailActivity
import com.choius323.domain.model.Category
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BroadListFragment : Fragment() {

    private val broadListViewModel: BroadListViewModel by viewModels()
    private var _binding: FragmentBroadListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBroadListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = BroadRecyclerViewAdapter {
            Log.d("BroadListFragment", "initRecyclerView: $it")
            if (it != null) BroadDetailActivity.newInstance(requireContext(), it)
        }
        adapter.addLoadStateListener { state ->
            Log.d("BroadListFragment", "initRecyclerView: $state")
            if (state.source.refresh is LoadState.NotLoading
                && state.append.endOfPaginationReached
                && adapter.itemCount < 1
            ) {
                binding.rvBroad.isVisible = false
                binding.tvEmptyBroadList.isVisible = true
            } else {
                binding.rvBroad.isVisible = true
                binding.tvEmptyBroadList.isVisible = false
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            broadListViewModel.broadList.collectLatest { data ->
                adapter.submitData(data)
            }
        }
        binding.rvBroad.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(category: Category): BroadListFragment {
            val bundle = Bundle().apply {
                putSerializable(KEY_CATEGORY, category)
            }
            return BroadListFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}