package com.bryansinqadu.admin_panel;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {



        private Context mCtx;


        private List<Users> usersList;


        public UsersAdapter(Context mCtx, List<Users> usersList) {
            this.mCtx = mCtx;
            this.usersList = usersList;
        }

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.layout_users, null);
            return new UserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, int position) {

            Users product = usersList.get(position);


            holder.name.setText(String.valueOf(product.getName()));
            holder.email.setText(String.valueOf(product.getEmail()));
            holder.phone.setText(String.valueOf(product.getPhone()));

        }


        @Override
        public int getItemCount() {
            return usersList.size();
        }


        class UserViewHolder extends RecyclerView.ViewHolder {

            TextView name, email, phone;

            public UserViewHolder(View itemView) {
                super(itemView);

                name = itemView.findViewById(R.id.etName);
                email = itemView.findViewById(R.id.etEmail);
                phone = itemView.findViewById(R.id.etPhone);
            }
        }

}
