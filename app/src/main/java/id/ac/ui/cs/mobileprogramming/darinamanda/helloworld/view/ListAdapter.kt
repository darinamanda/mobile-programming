package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.view
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.R
import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.model.Powerpuff

import kotlinx.android.synthetic.main.fragment_item.view.*
import kotlin.collections.List

class ListAdapter(val list: ArrayList<Powerpuff>) :

    RecyclerView.Adapter<ListAdapter.PowerpuffViewHolder>() {

    fun updateList(newList: List<Powerpuff>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerpuffViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_item, parent, false)
        return PowerpuffViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PowerpuffViewHolder, position: Int) {
        holder.view.imageView.setImageResource(list[position].image)
        holder.view.name.text = list[position].name
        holder.view.type.text = list[position].type
        holder.view.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ListDirections.actionListToDetail().setId(position))
        }
    }

    class PowerpuffViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}