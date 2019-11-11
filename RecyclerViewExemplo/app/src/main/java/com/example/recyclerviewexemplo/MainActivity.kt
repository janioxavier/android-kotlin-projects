package com.example.recyclerviewexemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_message.*

class MainActivity : AppCompatActivity() {

    private var messages = mutableListOf<Message>()

    private var adapter = MessageAdapter(messages, this::onMessageItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycleView()

        fabAdd.setOnClickListener {
            messages.add(Message(edtTitle.text.toString(), edtText.text.toString()))
            adapter.notifyItemInserted(messages.lastIndex)

            edtTitle.text?.clear()
            edtText.text?.clear()

            edtTitle.requestFocus()
        }
    }

    fun initRecycleView() {
        rvMessages.adapter = adapter
        val layoutManager = LinearLayoutManager(this)

        rvMessages.layoutManager = layoutManager

        initSwipeDelete()
    }

    fun initSwipeDelete() {
        val swipe = object: ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                messages.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(rvMessages)
    }


    fun onMessageItemClick(message: Message) {
        var s = "${message.title}\n${message.text}"

        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }
}
