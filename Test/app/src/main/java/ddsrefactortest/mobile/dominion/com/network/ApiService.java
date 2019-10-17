package ddsrefactortest.mobile.dominion.com.network;

import ddsrefactortest.mobile.dominion.com.features.users.model.UsersListModel;
import ddsrefactortest.mobile.dominion.com.features.userspost.model.UserPostsModel;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author gowtham pr on 5/18/2018.
 *
 *         Api service configs
 */
public interface ApiService {

  /**
   * @return list of users model in {@link Observable} type
   */
  @GET("users") Observable<List<UsersListModel>> getUsersListApi();

  /**
   * @return list of user post in {@link Observable} type
   */
  @GET("posts") Observable<List<UserPostsModel>> getUsersPost(@Query("userId") String userId);
}
