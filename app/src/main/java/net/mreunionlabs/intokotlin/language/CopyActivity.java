package net.mreunionlabs.intokotlin.language;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import net.mreunionlabs.intokotlin.R;
import net.mreunionlabs.intokotlin.adapter.ItemAdapter;
import net.mreunionlabs.intokotlin.adapter.Item;
import net.mreunionlabs.intokotlin.recyclerview.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CopyActivity extends AppCompatActivity {

    private static final String TAG = "CopyActivity";

    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy);
        initActionToolbar();

        initRecyclerView();
        List <Item>items = new ArrayList<>();
        Item item = new Item();
        item.setTitle("Title 1");
        item.setContent("Content number 1");
        items.add(item);

        adapter = new ItemAdapter(this, items);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initActionToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.app_name));
        }
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Item item = adapter.getItem(position);

                Intent i = new Intent(getApplicationContext(), NextActivity.class);
                i.putExtra("title", item.getTitle());
                startActivity(i);
            }
        }));
    }

}
