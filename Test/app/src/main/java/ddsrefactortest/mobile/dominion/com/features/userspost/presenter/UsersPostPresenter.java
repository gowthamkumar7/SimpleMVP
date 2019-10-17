package ddsrefactortest.mobile.dominion.com.features.userspost.presenter;

import ddsrefactortest.mobile.dominion.com.base.BasePresenter;
import ddsrefactortest.mobile.dominion.com.features.userspost.model.UserPostsModel;
import ddsrefactortest.mobile.dominion.com.features.userspost.view.UsersPostView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;

/**
 * @author gowtham pr on 5/18/2018.
 */
public class UsersPostPresenter extends BasePresenter<UsersPostView> implements Observer {

  public UsersPostPresenter(UsersPostView view) {
    super(view);
  }

  /**
   * make n/w call to server
   *
   * @param userId user id
   */
  public void getUsersPost(String userId) {
    apiService.getUsersPost(userId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this);
  }

  @Override public void onSubscribe(Disposable d) {

  }

  @Override public void onNext(Object o) {
    if (o instanceof ArrayList) {
      ArrayList<UserPostsModel> usersPostList = (ArrayList<UserPostsModel>) o;
      mView.onGetUsersPosts(usersPostList);
    }
  }

  @Override public void onError(Throwable e) {

  }

  @Override public void onComplete() {

  }
}
