package com.aaron.searchinsameactivity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 查找结果页面
 */
public class SearchResultActivity extends Activity implements OnClickListener {

    private TextView tvquery, tvdata;
    private Button btnsearch;
    private SearchRecentSuggestions suggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);

        tvquery = (TextView) findViewById(R.id.tvquery);
        tvdata = (TextView) findViewById(R.id.tvdata);
        btnsearch = (Button) findViewById(R.id.btnSearch);
        btnsearch.setOnClickListener(this);

        doSearchQuery(getIntent());
    }

    /**
     * 从Intent中获取搜索的关键字
     * 开启悬浮搜索框
     */
    public void doSearchQuery(Intent intent) {
        //获得搜索框里值
        String query = intent.getStringExtra(SearchManager.QUERY);
        tvquery.setText(query);
        //保存搜索记录
        suggestions = new SearchRecentSuggestions(this,
                SearchSuggestionSampleProvider.AUTHORITY, SearchSuggestionSampleProvider.MODE);
        suggestions.saveRecentQuery(query, null);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            //获取传递的数据
            Bundle bundled = intent.getBundleExtra(SearchManager.APP_DATA);
            if (bundled != null) {
                String ttdata = bundled.getString("data");
                tvdata.setText(ttdata);
            } else {
                tvdata.setText("no data");
            }
        }
    }

    @Override
    public void onClick(View v) {
        onSearchRequested();
    }

    /**
     * 为了能够使用search bar 我们必须重写Activity的onSearchRequested的方法，在界面上启动一个search bar
     * 但是这个动作不会自动触发，必须通过一个按钮或者菜单的点击事件触发
     *
     * @return
     */
    @Override
    public boolean onSearchRequested() {
        startSearch("", false, null, false);
        return true;
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        doSearchQuery(intent);
    }

    /**
     * 清空搜索记录
     */
    private void clearSearchHistory() {
        suggestions.clearHistory();
    }
}
