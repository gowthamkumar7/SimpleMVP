package ddsrefactortest.mobile.dominion.com.features.userspost.view;

import ddsrefactortest.mobile.dominion.com.base.BaseView;
import ddsrefactortest.mobile.dominion.com.features.userspost.model.UserPostsModel;
import java.util.ArrayList;

/**
 * @author gowtham pr on 5/18/2018.
 */
public interface UsersPostView extends BaseView {

  void onGetUsersPosts(ArrayList<UserPostsModel> usersPostList);
}
