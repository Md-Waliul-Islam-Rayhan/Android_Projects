package com.test.start;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Custom_Adapter extends ArrayAdapter<AddUserDetails> {

    private Activity context;
    private List<AddUserDetails> IncomeDataList;

    public Custom_Adapter(Activity context, List<AddUserDetails> IncomeDataList) {
        super(context, R.layout.history_sample_view, IncomeDataList);
        this.context = context;
        this.IncomeDataList = IncomeDataList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.history_sample_view, null,true);

        AddUserDetails IncomeUserData = IncomeDataList.get(position);

        TextView IncomeType = view.findViewById(R.id.IncomeTypeSampleTextView);
        TextView IncomeAmount = view.findViewById(R.id.IncomeAmountSampleTextView);
        TextView IncomeComment = view.findViewById(R.id.IncomeCommentSampleTextView);

        IncomeType.setText("Income Type: "+IncomeUserData.getType());
        IncomeAmount.setText("Amount: "+IncomeUserData.getAmount());
        IncomeComment.setText("Comment: "+IncomeUserData.getComment());

        return view;
    }
}
