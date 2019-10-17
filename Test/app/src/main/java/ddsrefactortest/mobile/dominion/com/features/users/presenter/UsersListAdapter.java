package ddsrefactortest.mobile.dominion.com.features.users.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ddsrefactortest.mobile.dominion.com.features.users.model.UsersListModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gowtham pr on 5/18/2018.
 *
 *         Custom Adapter for list of users
 */
public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UserListViewholder> {

  private List<UsersListModel> mUsersList;

  private OnUserItemClickedListener mListener;

  public UsersListAdapter(OnUserItemClickedListener mListener) {
    this.mListener = mListener;
    mUsersList = new ArrayList<>(0);
  }

  @NonNull @Override
  public UserListViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(android.R.layout.simple_list_item_1, parent, false);
    return new UserListViewholder(view);
  }

  @Override public void onBindViewHolder(@NonNull UserListViewholder holder, int position) {
    UsersListModel usersListModel = mUsersList.get(position);
    holder.mTvUserName.setText(usersListModel.getName());
    holder.setOnClick(usersListModel.getId());
  }

  @Override public int getItemCount() {
    return mUsersList.size();
  }

  /**
   * update with new data
   */
  public void setUsersList(ArrayList<UsersListModel> usersModelList) {
    mUsersList = usersModelList;
    notifyDataSetChanged();
  }

  /**
   * Custom ViewHolder
   */
  class UserListViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(android.R.id.text1) TextView mTvUserName;
    private Long userId;

    public UserListViewholder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    /**
     * Enables onclick and sets the user id
     */
    void setOnClick(Long userId) {
      this.userId = userId;
      mTvUserName.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
      mListener.onItemClicked(userId);
    }
  }

  /**
   * Call back for on item clicked
   */
  public interface OnUserItemClickedListener {

    void onItemClicked(Long userId);
  }
}
