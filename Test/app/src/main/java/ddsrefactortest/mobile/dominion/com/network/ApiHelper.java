package ddsrefactortest.mobile.dominion.com.network;

import ddsrefactortest.mobile.dominion.com.utils.Constants;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author gowtham pr on 5/18/2018.
 */
public class ApiHelper {

  private static Retrofit mRetrofit;
  //Creates OkHttpClient and adds 60 seconds Timeout
  private static OkHttpClient.Builder httpClient =
      new OkHttpClient.Builder().readTimeout(Constants.CONNECTION_TIME_OUT_PERIOD, TimeUnit.SECONDS)
          .writeTimeout(Constants.CONNECTION_TIME_OUT_PERIOD, TimeUnit.SECONDS)
          .connectTimeout(Constants.CONNECTION_TIME_OUT_PERIOD, TimeUnit.SECONDS);

  /* Private constructor for not being called from any other classes as this class's instance is singleton.*/
  private ApiHelper() {

  }

  /**
   * Return the singleton retrofit client
   */
  public static Retrofit getClient() {

    if (mRetrofit == null) {
      OkHttpClient client = httpClient.build();
      mRetrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .build();
      return mRetrofit;
    } else {
      return mRetrofit;
    }
  }
}
