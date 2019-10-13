 
package com.motiv.example
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.*
import com.squareup.picasso.Picasso
import kotlin.collections.List
import kotlinx.android.synthetic.main.userslistadapter.view.*

public class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.AdapterViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    private var data: ArrayList<User> = ArrayList()

    public interface OnItemClickListener {

        public fun onItemClick(position: Int, item: com.motiv.example.User): Unit
    }

    public class AdapterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var linearlayout00: LinearLayout = view.linearlayout00
        var imageview10: ImageView = view.imageview10
        var textview11: TextView = view.textview11
    }

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
        val row: View = inflater.inflate(R.layout.userslistadapter, parent, false)
        return AdapterViewHolder(row)
    } override fun onBindViewHolder(viewHolder: AdapterViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            if (onItemClickListener != null)
                onItemClickListener?.onItemClick(position, data.get(position))
        }
        val user: User = data.get(position)
        viewHolder.textview11.setText(user.getFirst_name())

        Picasso.with(viewHolder.itemView.getContext()).load(user.getLinks().getAvatar().getHref()).into(viewHolder.imageview10)
    } fun setOnItemClickListener(onItemClickListener: com.motiv.example.UsersListAdapter.OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}
