package ddsrefactortest.mobile.dominion.com.features.userspost.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import ddsrefactortest.mobile.dominion.com.R;
import ddsrefactortest.mobile.dominion.com.base.BaseActivity;
import ddsrefactortest.mobile.dominion.com.features.userspost.model.UserPostsModel;
import ddsrefactortest.mobile.dominion.com.features.userspost.presenter.UsersPostAdapter;
import ddsrefactortest.mobile.dominion.com.features.userspost.presenter.UsersPostPresenter;
import ddsrefactortest.mobile.dominion.com.utils.Constants;
import java.util.ArrayList;

public class UsersPostActivity extends BaseActivity<UsersPostPresenter> implements UsersPostView {

  @BindView(R.id.id_rcv_users_post) RecyclerView mRcvUsersPost;
  @BindView(R.id.id_pb_users_post) ProgressBar mPbusersPost;

  private UsersPostAdapter mUsersPostAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    mUsersPostAdapter = new UsersPostAdapter();
    LinearLayoutManager linearLayoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    mRcvUsersPost.setLayoutManager(linearLayoutManager);
    mRcvUsersPost.setAdapter(mUsersPostAdapter);
    String userId = getIntentUserId();
    mPresenter.getUsersPost(userId);
  }

  /**
   * get user id from previous screen
   */
  private String getIntentUserId() {
    String userId = Long.toString(getIntent().getExtras().getLong(Constants.EXTRA_USER));
    return userId;
  }

  @Override protected UsersPostPresenter createPresenter() {
    return new UsersPostPresenter(this);
  }

  @Override public int getContextView() {
    return R.layout.activity_users_post;
  }

  @Override public void onGetUsersPosts(ArrayList<UserPostsModel> usersPostList) {
    mPbusersPost.setVisibility(View.GONE);
    mUsersPostAdapter.setUsersPosts(usersPostList);
  }
}
