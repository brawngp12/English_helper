package com.example.english_helper;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class CustomList_nguphap extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] web;
	private final String[] imageId;

	public CustomList_nguphap(Activity context, String[] web, String[] imageId) {
		super(context, R.layout.item_nguphap, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.item_nguphap, null, true);
		TextView txtTitle = (TextView) rowView
				.findViewById(R.id.tv_item_noidung);
		txtTitle.setText(web[position]);

		TextView tvtrang = (TextView) rowView.findViewById(R.id.tv_item_trang);

		tvtrang.setText(imageId[position]);

		return rowView;
	}
}