package ddsrefactortest.mobile.dominion.com.features.users.presenter;

import ddsrefactortest.mobile.dominion.com.base.BasePresenter;
import ddsrefactortest.mobile.dominion.com.features.users.model.UsersListModel;
import ddsrefactortest.mobile.dominion.com.features.users.view.UsersView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;

/**
 * @author gowtham pr on 5/18/2018.
 *
 *         Presenter for user list
 */
public class UsersPresenter extends BasePresenter<UsersView> implements Observer {

  public UsersPresenter(UsersView view) {
    super(view);
  }

  /**
   * Make n/w call to server
   */
  public void getUsersList() {
    // network call to server
    apiService.getUsersListApi()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this);
  }

  @Override public void onSubscribe(Disposable d) {

  }

  @Override public void onNext(Object o) {
    if (o instanceof ArrayList) {
      ArrayList<UsersListModel> usersModelList = (ArrayList<UsersListModel>) o;
      //dispatch results to view
      mView.onGetUsersList(usersModelList);
    }
  }

  @Override public void onError(Throwable e) {
    showSnackBar(e.getMessage());
  }

  @Override public void onComplete() {

  }
}
