package com.dev.recyceler;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewerAdapter extends RecyclerView.Adapter<RecycleViewerAdapter.ViewHolder> {

    Context context;
    ArrayList<contract_sample_java_model> arrayList;
    RecycleViewerAdapter(Context context, ArrayList<contract_sample_java_model> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contract_sample_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //contract_sample_java_model model = (contract_sample_java_model) arrayList.get(position);
        holder.imgView.setImageResource(arrayList.get(position).img);
        holder.nameTextView.setText(arrayList.get(position).name);
        holder.numberTextView.setText(arrayList.get(position).number);

        anim(holder.itemView, position);

        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_item_layout);

                EditText nameET, numberET;
                TextView addContacts;
                Button addButton;

                nameET = dialog.findViewById(R.id.nameEditText);
                numberET = dialog.findViewById(R.id.contact_number_EditText);
                addButton = dialog.findViewById(R.id.addButton);
                addContacts = dialog.findViewById(R.id.add_contacts);

                addContacts.setText("UPDATE CONTACTS");

                nameET.setText(arrayList.get(position).name);
                numberET.setText(arrayList.get(position).number);

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="", number="";

                        if (!nameET.getText().toString().equals("")){
                            name = nameET.getText().toString();
                        }
                        else{
                            nameET.setError("Enter name please");
                        }

                        if (!numberET.getText().toString().equals("")){
                            number = numberET.getText().toString();
                        }
                        else{
                            numberET.setError("Enter number please");
                        }

                        arrayList.set(position, new contract_sample_java_model(arrayList.get(position).img, name, number));
                        notifyItemChanged(position);


                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context)
                        .setTitle("Delete Contacts")
                        .setMessage("Are you sure want to delete?")
                        .setIcon(R.drawable.ic_baseline_delete_forever_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrayList.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                dialog.show();


                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, numberTextView;
        ImageView imgView;
        LinearLayout llrow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.NameId);
            numberTextView = itemView.findViewById(R.id.NumberId);
            imgView = itemView.findViewById(R.id.ImgId);
            llrow = itemView.findViewById(R.id.LLrow);
        }
    }

    private void anim(View view, int position){
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }

}
