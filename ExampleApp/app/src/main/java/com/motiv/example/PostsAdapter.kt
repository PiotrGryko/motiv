 
package com.motiv.example
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.*
import kotlin.collections.List
import kotlinx.android.synthetic.main.postsadapter.view.*

public class PostsAdapter : RecyclerView.Adapter<PostsAdapter.AdapterViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    private var data: ArrayList<Post> = ArrayList()

    public interface OnItemClickListener {

        public fun onItemClick(position: Int, item: com.motiv.example.Post): Unit
    }

    public class AdapterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var linearlayout00: LinearLayout = view.linearlayout00
        var textview10: TextView = view.textview10
    }

    override fun getItemCount(): Int {
        return data.size
    } fun getElement(position: Int): Post {
        return data.get(position)
    } fun setData(newData: List<com.motiv.example.Post>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    } override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): AdapterViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val row: View = inflater.inflate(R.layout.postsadapter, parent, false)
        return AdapterViewHolder(row)
    } override fun onBindViewHolder(viewHolder: AdapterViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            if (onItemClickListener != null)
                onItemClickListener?.onItemClick(position, data.get(position))
        }
        val post: Post = data.get(position)
        viewHolder.textview10.setText(post.getTitle())
    } fun setOnItemClickListener(onItemClickListener: com.motiv.example.PostsAdapter.OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}
