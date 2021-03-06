package com.example.asus.stock_control.ui.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asus.stock_control.R;
import com.example.asus.stock_control.dialog.Dialog_PurchaseOrderActivity_Add;
import com.example.asus.stock_control.dialog.Dialog_PurchaseOrderActivity_Delete;
import com.example.asus.stock_control.dialog.Dialog_PurchaseOrderActivity_Editor;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/1/11.
 */

public class PurchaseOrderActivity extends BaseAcitivty {

    @BindView(R.id.tool_bar)
    Toolbar Too_bar;
    @BindView(R.id.recyclerView_PurchaseOrder)
    RecyclerView recyclerViewPurchaseOrder;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchaseorder);
        ButterKnife.bind(this);
        setSupportActionBar(Too_bar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.go_back);
            actionBar.setTitle("订单");
        }
        initSwipeRefresh();
    }

    private void initSwipeRefresh() {
        swipeRefresh.setColorSchemeResources(R.color.primary_color,R.color.accent_color);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_purchaseorder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.meun_add_purchaseorder:
                Dialog dialogAdd = new Dialog_PurchaseOrderActivity_Add(PurchaseOrderActivity.this, R.style.editor);
                dialogAdd.setContentView(R.layout.dialog_activity_editor_add_purchaseorder);
                dialogAdd.show();
                break;
            case R.id.meun_editor_purchaseorder:
                Dialog dialogEditor = new Dialog_PurchaseOrderActivity_Editor(PurchaseOrderActivity.this, R.style.editor);
                dialogEditor.setContentView(R.layout.dialog_activity_editor_editor_purchaseorder);
                dialogEditor.show();
                break;
            case R.id.meun_delete_purchaseorder:
                Dialog dialogDelete = new Dialog_PurchaseOrderActivity_Delete(PurchaseOrderActivity.this, R.style.editor);
                dialogDelete.setContentView(R.layout.dialog_activity_editor_delete_purchaseorder);
                dialogDelete.show();
                break;
        }
        return true;
    }
}
