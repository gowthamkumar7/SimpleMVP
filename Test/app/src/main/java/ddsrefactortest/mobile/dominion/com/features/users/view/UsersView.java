package ddsrefactortest.mobile.dominion.com.features.users.view;

import ddsrefactortest.mobile.dominion.com.base.BaseView;
import ddsrefactortest.mobile.dominion.com.features.users.model.UsersListModel;
import java.util.ArrayList;

/**
 * @author gowtham pr on 5/18/2018.
 */
public interface UsersView extends BaseView {
  void onGetUsersList(ArrayList<UsersListModel> usersModelList);
}
