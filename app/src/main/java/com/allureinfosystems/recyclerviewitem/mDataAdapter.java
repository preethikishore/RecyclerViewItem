package com.allureinfosystems.recyclerviewitem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

public class mDataAdapter extends RecyclerView.Adapter<mDataAdapter.MyViewHolder> {
    private ArrayList<HashMap<String, String>> dataSet;
    Context context;
   // private String[] urldata;


    public mDataAdapter(Context context,ArrayList< HashMap<String, String>> dataSet) {
        this.dataSet = dataSet;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_data, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final HashMap<String, String> Details = dataSet.get(position);
        holder.country.setText(Details.get("CName"));
        holder.flag.setImageResource(Integer.parseInt((Details.get("Cflag"))));

        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String website = Details.get("Curl");
              //  Log.i("Clicked site ",website);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                context.startActivity(browserIntent);


            }
        });

    }

    @Override

    public int getItemCount() {
        return (dataSet == null) ? 0 : dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView country;
        ImageView flag;
        Button visit;




        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            country = (TextView) itemView.findViewById(R.id.countryname);
            flag = (ImageView) itemView.findViewById(R.id.flagname);
            visit = (Button) itemView.findViewById(R.id.website);

        }
    }
}

