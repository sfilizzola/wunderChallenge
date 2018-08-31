package dev.com.sfilizzola.wunderchallenge.adapter

import dev.com.sfilizzola.wunderchallenge.R
import dev.com.sfilizzola.wunderchallenge.databinding.CarRowItemBinding
import dev.com.sfilizzola.wunderchallenge.models.Car
import dev.com.sfilizzola.wunderchallenge.viewmodels.CarItemRowViewModel

class CarListAdapter : BaseAdapter<Car, CarRowItemBinding>(R.layout.car_row_item){


    override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.name == newItem.name
    }

    override fun bind(holder: DataBindViewHolder<CarRowItemBinding>, position: Int) {
        holder.binding.viewModel = CarItemRowViewModel(items[position])
    }

}