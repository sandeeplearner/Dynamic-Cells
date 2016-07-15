package Adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.sandeepbhandari.dynamic_cell.R;

import java.util.List;

import Models.Users;

/**
 * Created by sandeepbhandari on 7/15/16.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<Users> usersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public EditText nameTextField, ageTextField;

        public MyViewHolder(View view) {
            super(view);
            nameTextField = (EditText) view.findViewById(R.id.nameText);
            ageTextField = (EditText) view.findViewById(R.id.ageText);
        }
    }

    public UsersAdapter(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.individual_cell, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Users user = usersList.get(position);
        holder.nameTextField.setTag(Integer.toString(position));
        holder.ageTextField.setTag(Integer.toString(position));

        if(user.getName() !=null) {
            holder.nameTextField.setText(user.getName());
        }
        else{
            holder.nameTextField.setText("");
        }
        if(user.getAge() != 0) {
            holder.ageTextField.setText(String.valueOf(user.getAge()));
        }
        else{
            holder.ageTextField.setText("");
        }

        holder.nameTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count != before) {
                    Users user = usersList.get(Integer.parseInt(holder.nameTextField.getTag().toString()));
                    user.setName(holder.nameTextField.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Sandeep","Am here");
            }
        });

        holder.ageTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count != before) {
                    if (holder.ageTextField.getText().toString() != null && !holder.ageTextField.getText().toString().equals("")) {
                        Users user = usersList.get(Integer.parseInt(holder.nameTextField.getTag().toString()));
                        user.setAge(Integer.parseInt(holder.ageTextField.getText().toString()));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Sandeep","Am here");
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
