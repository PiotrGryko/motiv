 
package com.motiv.example
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import com.motiv.example.databinding.PostsadapterBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
import kotlinx.android.synthetic.main.postsadapter.view.*

public class PostsAdapter : RecyclerView.Adapter<PostsAdapter.AdapterViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    private var data: ArrayList<Post> = ArrayList()

    public interface OnItemClickListener {

        public fun onItemClick(position: Int, item: com.motiv.example.Post): Unit
    }

    public class AdapterViewHolder(val binding: PostsadapterBinding) : RecyclerView.ViewHolder(binding.getRoot())

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
        val binding: PostsadapterBinding = PostsadapterBinding.inflate(inflater)
        return AdapterViewHolder(binding)
    } override fun onBindViewHolder(viewHolder: AdapterViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            if (onItemClickListener != null)
                onItemClickListener?.onItemClick(position, data.get(position))
        }
        val post: Post = data.get(position)
        viewHolder.binding.textview10.setText(post.getTitle())
    } fun setOnItemClickListener(onItemClickListener: com.motiv.example.PostsAdapter.OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}
