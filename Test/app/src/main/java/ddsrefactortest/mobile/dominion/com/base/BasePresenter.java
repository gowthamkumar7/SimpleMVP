package ddsrefactortest.mobile.dominion.com.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import ddsrefactortest.mobile.dominion.com.network.ApiHelper;
import ddsrefactortest.mobile.dominion.com.network.ApiService;

/**
 * @author gowtham pr on 5/18/2018.
 *
 *         Presenter, all i/o operations goes here
 */
public class BasePresenter<T extends BaseView> {
  protected T mView;
  public ApiService apiService;

  protected BasePresenter(T view) {
    mView = view;
    apiService = ApiHelper.getClient().create(ApiService.class);
  }

  @CallSuper public void onCreate(@Nullable final Bundle savedInstanceState) {

  }

  @CallSuper public void onDestroy() {
    //avoid memory leak
    mView = null;
    apiService = null;
  }

  public void showSnackBar(String message) {
    Snackbar.make((View) mView, message, Snackbar.LENGTH_LONG).show();
  }
}
