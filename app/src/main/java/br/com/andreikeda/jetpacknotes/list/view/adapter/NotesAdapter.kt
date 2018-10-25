package br.com.andreikeda.jetpacknotes.list.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.andreikeda.jetpacknotes.R
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

class NotesAdapter(context: Context) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mNotes: List<NoteEntity>? = null

    fun setData(notes: List<NoteEntity>) {
        mNotes = notes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView = mInflater.inflate(R.layout.item_note, parent, false)
        return NotesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mNotes?.size ?: run { 0 }
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        mNotes?.get(position)?.let {
            holder.isFinishedItemVew.isChecked = it.isFinished
            holder.descriptionItemView.text = it.description
            holder.titleItemView.text = it.name
        } ?: run {

        }
    }

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val isFinishedItemVew = itemView.findViewById<CheckBox>(R.id.checkBox_completed)
        val descriptionItemView = itemView.findViewById<TextView>(R.id.textView_title)
        val titleItemView = itemView.findViewById<TextView>(R.id.textView_description)
    }
}