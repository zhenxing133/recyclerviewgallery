package com.gallery.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rc_view)
    MyRecyclerView rcView;
    int[] icon = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
    @BindView(R.id.id_content)
    ImageView idContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initAdapter();
    }

    private void initAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcView.setLayoutManager(manager);
        MyAdapter adapter = new MyAdapter(icon, this);
        rcView.setAdapter(adapter);
        adapter.setOnIvItemClickListener(new MyAdapter.OnIvItemClickListener() {
            @Override
            public void onIvClick(View v, int position) {
                idContent.setImageResource(icon[position]);
            }
        });
        rcView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                idContent.setImageResource(icon[position]);
            }
        });
    }
}
