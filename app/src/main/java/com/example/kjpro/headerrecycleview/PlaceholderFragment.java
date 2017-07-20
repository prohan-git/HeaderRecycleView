package com.example.kjpro.headerrecycleview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/****
 *  Project_Name:    HeaderRecycleView
 *  Copyright:       Copyright  2012-2017 G-emall Technology Co.,Ltd
 *  Version:         1.0.0.1
 *  Created:         Tijun.han on 2017/7/17 0017 17:32.
 *  E-mail:          tijun.han@g-emall.com
 *  Desc:            
 ****/
public class PlaceholderFragment extends Fragment {
    private RecyclerView mRecyclerView;


    /////////////////////////////////////////////////////////
    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private int pageNum = 1;
    private int pageSize = 10;
    private View loadMoreView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initRecycleLayout(rootView);
        return rootView;
    }

    /**
     * 初始化RecycleView
     *
     * @param rootView
     */
    private void initRecycleLayout(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycle);
        //mRecyclerView.setHasFixedSize(true);//item宽度一致
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        MyAdapter mInAdapter = new MyAdapter(getResources().getStringArray(R.array.query_suggestions));
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mInAdapter);
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        createHeadView();
        createHeadView();
        createHeadView();
        createLoadMoreView();
        createLoadMoreView();
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int i) {
                pageNum++;
                loadData();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });

    }


    protected void loadData() {
    }

//    onLoadFinsh(){

//        loadMoreView.setVisibility(View.GONE);
    // TODO: 2017/7/18 0018  更新其他header
//
//        if (pageNum * pageSize - pageSize - 1 > 0) {
//            mHeaderViewRecyclerAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
//        } else {
//            mHeaderViewRecyclerAdapter.notifyDataSetChanged();
//        }
//    }


    private void createHeadView() {
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.header, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
    }

    private void createLoadMoreView() {
        View loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_load_more, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
        //loadMoreView.setVisibility(View.GONE);
    }
}
