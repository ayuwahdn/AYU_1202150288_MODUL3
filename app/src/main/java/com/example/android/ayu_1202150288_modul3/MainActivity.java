package com.example.android.ayu_1202150288_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //inisialisasi array
    private ArrayList<Water> mWaterData;
    //inisialisasi adapter
    private WaterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the RecyclerView
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //Initialize the ArrayList that will contain the data
        mWaterData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new WaterAdapter(this, mWaterData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

        //inisialisasi adapter untuk recycleView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Helper class for creating swipe to dismiss and drag and drop functionality
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //inisialisasi posisi gambar
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                Collections.swap(mWaterData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                mWaterData.remove(viewHolder.getAdapterPosition()); //hapus cardview

                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition()); //memberitahu adapter cardview terhapus
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);
    }

    private void initializeData() {
            //Get the resources from the XML file
            String[] waterList = getResources().getStringArray(R.array.air_titles);
            String[] waterInfo = getResources().getStringArray(R.array.info_water);
            TypedArray waterImageResources = getResources().obtainTypedArray(R.array.images_water);

            //Clear the existing data (to avoid duplication)
            mWaterData.clear();

            // and information about each sport
            for(int i=0; i<waterList.length; i++){
                mWaterData.add(new Water(waterList[i], waterInfo[i],
                        waterImageResources.getResourceId(i,0)));
            }

            //Recycle the typed array
            waterImageResources.recycle();

            //Notify the adapter of the change
            mAdapter.notifyDataSetChanged();
        }

    public void resetWater(View view) {

            initializeData();
    }
}

