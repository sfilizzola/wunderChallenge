package dev.com.sfilizzola.wunderchallenge.view.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.com.sfilizzola.wunderchallenge.R
import dev.com.sfilizzola.wunderchallenge.adapter.CarListAdapter
import dev.com.sfilizzola.wunderchallenge.databinding.FragmentListBinding
import dev.com.sfilizzola.wunderchallenge.view.viewStatus.ListViewStatus
import dev.com.sfilizzola.wunderchallenge.viewmodels.ListFragmentViewModel
import javax.inject.Inject

class ListFragment : BaseFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(ListFragmentViewModel::class.java) }

    private lateinit var binding: FragmentListBinding
    private lateinit var carAdapter: CarListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.viewModel = viewModel

        carAdapter = CarListAdapter()

        with(binding.carsRecycler){
            this.setHasFixedSize(true)
            this.adapter = carAdapter
            this.layoutManager = LinearLayoutManager(context)
        }

        viewModel.getData().observe(this, Observer{
            it?.let { result ->
                when(result) {
                    is ListViewStatus.Success -> carAdapter.update(it.list())
                    is ListViewStatus.Error ->  displaySnackBarError()
                }
            }
        })

        return binding.root

    }

    private fun displaySnackBarError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCars()
    }
}