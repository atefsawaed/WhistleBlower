package com.android.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageListAdapter extends BaseAdapter {

    List<Message> messages = new ArrayList<Message>();
    Context context;

    public MessageListAdapter(Context context) {
        this.context = context;
    }

    public void add(Message message) {
        this.messages.add(message);
        notifyDataSetChanged(); // to render the list we need to notify
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    // This function handles the creation of single chat bubble in the chat group
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        MessageViewHolder holder = new MessageViewHolder();
        LayoutInflater messageInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Message message = messages.get(i);

        if (message.isBelongsToCurrentUser()) { // a message sent by app user
            convertView = messageInflater.inflate(R.layout.item_message_sent, null);

            holder.messageBody = (TextView) convertView.findViewById(R.id.text_message_body);
            convertView.setTag(holder);
            holder.messageBody.setText(message.getContent());

            holder.messageTime = (TextView) convertView.findViewById(R.id.text_message_time);
            holder.messageTime.setText(message.getTime());

        } else { // this message was sent by someone else in the group
            convertView = messageInflater.inflate(R.layout.item_message_received, null);
            holder.avatar = (View) convertView.findViewById(R.id.image_message_profile);
//            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.messageBody = (TextView) convertView.findViewById(R.id.text_message_body);
            convertView.setTag(holder);
//            holder.name.setText(message.getData().getName());
            holder.messageBody.setText(message.getContent());
            GradientDrawable drawable = (GradientDrawable) holder.avatar.getBackground();
//            drawable.setColor(Color.parseColor(message.getData().getColor()));
        }
        return convertView;
    }

}

class MessageViewHolder {
    public View avatar;
    public TextView name;
    public TextView messageBody;
    public TextView messageTime;
}