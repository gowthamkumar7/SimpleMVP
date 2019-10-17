package ddsrefactortest.mobile.dominion.com.features.userspost.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused") public class UserPostsModel {

  @SerializedName("body") private String mBody;
  @SerializedName("id") private Long mId;
  @SerializedName("title") private String mTitle;
  @SerializedName("userId") private Long mUserId;

  public String getBody() {
    return mBody;
  }

  public void setBody(String body) {
    mBody = body;
  }

  public Long getId() {
    return mId;
  }

  public void setId(Long id) {
    mId = id;
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String title) {
    mTitle = title;
  }

  public Long getUserId() {
    return mUserId;
  }

  public void setUserId(Long userId) {
    mUserId = userId;
  }
}
