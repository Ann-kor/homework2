package chapter.android.aweme.ss.com.homework;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class msgAdapter extends RecyclerView.Adapter<msgAdapter.ViewHolder>{

    private List<Message> mmsgList;
    /*点击rv的item跳转*/
    OnItemClickListener listener;
    public interface OnItemClickListener{
        /*注意参数*/
        public void OnItemClick(View v,int position,String id);
    }
    public void setOnItemClick(OnItemClickListener listener){
        this.listener=listener;
    }



    static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView isOfficial;
            ImageView header;
            TextView title;
            TextView description;
            TextView time;

            public ViewHolder (View view)
            {
                super(view);
                isOfficial = (ImageView) view.findViewById(R.id.robot_notice);
                header = (CircleImageView) view.findViewById(R.id.iv_avatar);
                title = (TextView) view.findViewById(R.id.tv_title);
                description = (TextView) view.findViewById(R.id.tv_description);
                time = (TextView) view.findViewById(R.id.tv_time);
            }

        }

        public msgAdapter(List <Message> msgList){
            mmsgList = msgList;
        }

        @Override

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.im_list_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position){
            int id = 0;
            Message msg = mmsgList.get(position);
            Log.e("hhhhhhhhhhhhhh",msg.toString());
            if(msg.isOfficial()==true)
            {
                holder.isOfficial.setVisibility(View.VISIBLE);
            }
            else
            {
                holder.isOfficial.setVisibility(View.INVISIBLE);
            }
            holder.title.setText(msg.getTitle());
            holder.description.setText(msg.getDescription());
            holder.time.setText(msg.getTime());
            if(msg.getIcon().equals("TYPE_ROBOT")){
                id = R.drawable.session_robot;
                holder.header.setBackgroundResource(id);
            }
            else if(msg.getIcon().equals("TYPE_GAME")){
                id = R.drawable.icon_micro_game_comment;
                holder.header.setBackgroundResource(id);
            }
            else if(msg.getIcon().equals("TYPE_SYSTEM")){
                id = R.drawable.session_system_notice;
                holder.header.setBackgroundResource(id);
            }
            else if(msg.getIcon().equals("TYPE_STRANGER")){
                id = R.drawable.session_stranger;
                holder.header.setBackgroundResource(id);
            }
            else if(msg.getIcon().equals("TYPE_USER")){
                id = R.drawable.icon_girl;
                holder.header.setBackgroundResource(id);
            }

            /*点击rv的item跳转*/
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        /*注意参数*/
                        listener.OnItemClick(v,position,mmsgList.get(position).getTitle());
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mmsgList.size();
        }

    }
