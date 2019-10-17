package ddsrefactortest.mobile.dominion.com.features.userspost.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ddsrefactortest.mobile.dominion.com.R;
import ddsrefactortest.mobile.dominion.com.features.userspost.model.UserPostsModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gowtham pr on 5/18/2018.
 */
public class UsersPostAdapter extends RecyclerView.Adapter<UsersPostAdapter.UsersPostViewHolder> {

  private List<UserPostsModel> mUserPostList;

  public UsersPostAdapter() {
    mUserPostList = new ArrayList<>();
  }

  @NonNull @Override
  public UsersPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_post, parent, false);
    return new UsersPostViewHolder(view);
  }

  @Override public void onBindViewHolder(@NonNull UsersPostViewHolder holder, int position) {
    holder.mTvTitle.setText(mUserPostList.get(position).getTitle());
    holder.mTvBody.setText(mUserPostList.get(position).getBody());
  }

  @Override public int getItemCount() {
    return mUserPostList.size();
  }

  /**
   * sets the new data set
   */
  public void setUsersPosts(ArrayList<UserPostsModel> usersPostList) {
    this.mUserPostList = usersPostList;
    notifyDataSetChanged();
  }

  class UsersPostViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title) TextView mTvTitle;
    @BindView(R.id.body) TextView mTvBody;

    public UsersPostViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
