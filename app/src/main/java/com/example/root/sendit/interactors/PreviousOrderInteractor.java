package com.example.root.sendit.interactors;

import android.content.Context;

import com.example.root.sendit.adapters.OrdersAdapter;
import com.example.root.sendit.helperclasses.FirebaseOpsHelper;
import com.example.root.sendit.items.OrderReceived;
import com.example.root.sendit.presenters.PreviousOrderPresenter;

import java.util.ArrayList;

public class PreviousOrderInteractor {

    private PreviousOrderPresenter mPresenter;
    private Context context;
    private OrdersAdapter mOrdersAdapter;

    public PreviousOrderInteractor(PreviousOrderPresenter presenter) {
        this.mPresenter = presenter;
    }

    public void fetchPreviousOrdersData() {
        FirebaseOpsHelper fbHelper = new FirebaseOpsHelper();
        fbHelper.onPreviousOrdersCall(this);
    }

    public void onReceivedPreviousOrdersData(ArrayList<OrderReceived> orderList) {
        mPresenter.sendContext();
        mOrdersAdapter = new OrdersAdapter(orderList, context);
        mPresenter.onAdapterReady();
    }

    public void setInteractorContext(Context context) {
        this.context = context;
    }

    public OrdersAdapter sendOrdersAdapter() {
        return mOrdersAdapter;
    }

}
