package ddsrefactortest.mobile.dominion.com.features.users.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import ddsrefactortest.mobile.dominion.com.R;
import ddsrefactortest.mobile.dominion.com.base.BaseActivity;
import ddsrefactortest.mobile.dominion.com.features.users.model.UsersListModel;
import ddsrefactortest.mobile.dominion.com.features.users.presenter.UsersListAdapter;
import ddsrefactortest.mobile.dominion.com.features.users.presenter.UsersPresenter;
import ddsrefactortest.mobile.dominion.com.features.userspost.view.UsersPostActivity;
import ddsrefactortest.mobile.dominion.com.utils.Constants;
import java.util.ArrayList;

/**
 * @author gowtham pr
 *
 *         Displays users list
 */
public class UsersListActivity extends BaseActivity<UsersPresenter>
    implements UsersView, UsersListAdapter.OnUserItemClickedListener {

  @BindView(R.id.id_rcv_users) RecyclerView mRcvUsers;
  @BindView(R.id.id_pb_users) ProgressBar mPbusers;
  private UsersListAdapter mUsersListAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);

    mUsersListAdapter = new UsersListAdapter(this);
    LinearLayoutManager linearLayoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    mRcvUsers.setLayoutManager(linearLayoutManager);
    mRcvUsers.setAdapter(mUsersListAdapter);
    //fetch data
    mPresenter.getUsersList();
  }

  @Override protected UsersPresenter createPresenter() {
    return new UsersPresenter(this);
  }

  @Override public int getContextView() {
    return R.layout.activity_main;
  }

  /**
   * Onclick on item navigate to user's post screen
   */
  @Override public void onItemClicked(Long userId) {
    Intent intent = new Intent(this, UsersPostActivity.class);
    intent.putExtra(Constants.EXTRA_USER, userId);
    startActivity(intent);
  }

  /**
   * Update the fetched data to UI
   *
   * @param usersModelList list of users
   */
  @Override public void onGetUsersList(ArrayList<UsersListModel> usersModelList) {
    mPbusers.setVisibility(View.GONE);
    mUsersListAdapter.setUsersList(usersModelList);
  }
}
