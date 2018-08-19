package com.bryansinqadu.admin_panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> {



    private Context mCtx;


    private List<Staff> staffList;


    public StaffAdapter(Context mCtx, List<Staff> staffList) {
        this.mCtx = mCtx;
        this.staffList = staffList;
    }

    @Override
    public StaffViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_users, null);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StaffViewHolder holder, int position) {

        Staff staff = staffList.get(position);


        holder.name.setText(String.valueOf(staff.getName()));
        holder.email.setText(String.valueOf(staff.getEmail()));
        holder.phone.setText(String.valueOf(staff.getPhone()));

        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(staff.getPicture()));

    }


    @Override
    public int getItemCount() {
        return staffList.size();
    }


    class StaffViewHolder extends RecyclerView.ViewHolder {

        TextView name, email, phone;

        public StaffViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.etName);
            email = itemView.findViewById(R.id.etEmail);
            phone = itemView.findViewById(R.id.etPhone);
        }
    }

}

