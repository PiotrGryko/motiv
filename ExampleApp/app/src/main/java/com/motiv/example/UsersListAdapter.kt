 
package com.motiv.example
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.motiv.example.databinding.UserslistadapterBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
import kotlinx.android.synthetic.main.userslistadapter.view.*

public class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.AdapterViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    private var data: ArrayList<User> = ArrayList()

    public interface OnItemClickListener {

        public fun onItemClick(position: Int, item: com.motiv.example.User): Unit
    }

    public class AdapterViewHolder(val binding: UserslistadapterBinding) : RecyclerView.ViewHolder(binding.getRoot())

    override fun getItemCount(): Int {
        return data.size
    } fun getElement(position: Int): User {
        return data.get(position)
    } fun setData(newData: List<com.motiv.example.User>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    } override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): AdapterViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: UserslistadapterBinding = UserslistadapterBinding.inflate(inflater)
        return AdapterViewHolder(binding)
    } override fun onBindViewHolder(viewHolder: AdapterViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            if (onItemClickListener != null)
                onItemClickListener?.onItemClick(position, data.get(position))
        }
        val user: User = data.get(position)
        viewHolder.binding.textview11.setText(user.getFirst_name())
        Glide.with(viewHolder.itemView.getContext())
            .load(user.getLinks().getAvatar().getHref())
            .into(viewHolder.binding.imageview10)
    } fun setOnItemClickListener(onItemClickListener: com.motiv.example.UsersListAdapter.OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}
