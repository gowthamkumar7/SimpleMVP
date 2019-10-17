package ddsrefactortest.mobile.dominion.com.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author gowtham pr on 5/18/2018.
 *
 *         Base Activity for all activities
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

  protected T mPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContextView());
    mPresenter = createPresenter();
  }

  protected abstract T createPresenter();

  public abstract int getContextView();
}
