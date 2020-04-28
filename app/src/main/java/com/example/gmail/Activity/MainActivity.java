package com.example.gmail.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gmail.R;
import com.example.gmail.adapters.ListAdapter;
import com.example.gmail.modes.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;

public class MainActivity extends AppCompatActivity {

    boolean isFavourite;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.btn_fb)
    Button btnFb;
    @BindView(R.id.rv)
    RecyclerView rv;
    List<Item> items = new ArrayList<>();
    List<Item> searchItem = new ArrayList<>();
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isFavourite = false;
        btnFb.requestFocus();
        rv.setHasFixedSize(true);
        setData();
        listAdapter = new ListAdapter(items);
        rv.setAdapter(listAdapter);

        Toast.makeText(this, "" + editText.getText().toString(), Toast.LENGTH_SHORT).show();
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFavourite == false) {
                    listAdapter.showFavourite();
                    ListAdapter listAdapter1 = new ListAdapter(ListAdapter.itemsAll);
                    rv.setAdapter(listAdapter1);
                } else {
                    listAdapter = new ListAdapter(items);
                    rv.setAdapter(listAdapter);
                }
                isFavourite = !isFavourite;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            //tim kiem key
            @Override
            public void afterTextChanged(Editable s) {
                searchItem.clear();
                listAdapter = new ListAdapter(searchItem);
                if (s.toString().length() >= 2) {
                    Log.d("aaa", "afterTextChanged: " + s.toString());
                    for (Item i : items) {
                        Log.d("aaa", "afterTextChanged: " + i.name.toString());
                        if (i.name.contains(s.toString())) {
                            searchItem.add(i);
                            Log.d("aaa", "true");
                            listAdapter.notifyDataSetChanged();
                        }
                    }
                    rv.setAdapter(listAdapter);
                }
            }
        });
        rv.setLayoutManager(new

                LinearLayoutManager(this));
    }

    public void setData() {
        items.add(new Item("G", "GitHub", "GitHub Satellite is just two weeks away! With a keynote and roadmap presentation from the GitHub team, product talks from developers around the world, stories from teams using GitHub, and even live-coded DJ sets, you don’t want to miss this one. Be part of it all at githubsatellite.com on May 6 at 9 am PT / 12 pm ET / 6 pm CET. Read on to see how you can share an idea or hack with the GitHub community during the event, and find more information about Satellite sessions."));
        items.add(new Item("L", "LinkedIn", "GitHub Satellite is just two weeks away! With a keynote and roadmap presentation from the GitHub team, product talks from developers around the world, stories from teams using GitHub, and even live-coded DJ sets, you don’t want to miss this one. Be part of it all at githubsatellite.com on May 6 at 9 am PT / 12 pm ET / 6 pm CET. Read on to see how you can share an idea or hack with the GitHub community during the event, and find more information about Satellite sessions."));
        items.add(new Item("L", "Lê Văn Linh", "Kính gửi các đồng chí,\n" +
                "\n" +
                "Thực hiện chỉ đạo của Đảng uỷ trường về việc triển khai thảo luận đóng góp ý kiến cho Dự thảo Báo cáo Đại hội Đảng bộ Trường ĐHBKHN lần thứ XXX, Chi uỷ gửi các đồng chí bản báo cáo đã tóm lược, trong đó tập trung vào các nội dung liên quan tới các công tác Đảng và các nội dung có liên quan trực tiếp tới sinh viên như cơ sở vật chất, học tập và nghiên cứu, các công tác Đoàn - Hội, cũng như mục tiêu, phương hướng và nhiệm vụ chủ yếu của nhiệm kì 2020 - 2025."));
        items.add(new Item("T", "Trần Duy Nhất", "Ông Ngô Tiến Hùng, Chánh văn phòng Tòa án nhân dân tối cao, cho biết: “Sau khi Hội đồng Nghệ thuật lựa chọn mẫu tượng, bức tượng được đặt tại Quảng trường Công lý- thuộc dự án trụ sở Tòa án nhân dân tối cao mới (số 43 Hai Bà Trưng, quận Hai Bà Trưng, Hà Nội). Thiết kế và kinh phí xây dựng tượng nằm trong gói dự án xây dựng trụ sở Tòa án nhân dân tối cao đã được các cơ quan nhà nước có thẩm quyền phê duyệt”."));
        items.add(new Item("N", "Nguyễn Trọng Huấn", "Mặc dù ông Hùng nói vậy, nhưng tại Văn bản số 141 của Tòa án nhân dân tối cao, do Phó chánh án Lê Hồng Quang ký, có đoạn: “Để chuẩn bị cho việc dựng tượng vua Lý Thái Tông đặt tại trụ sở Tòa án nhân dân tối cao và các tòa án nhân dân, tòa án quân sự các cấp, Tòa án nhân dân tối cao tổ chức lấy ý kiến của các thẩm phán Tòa án nhân dân tối cao, cán bộ công chức trong hệ thống tòa án đối với các mẫu phác thảo tượng vua Lý Thái Tông”."));
        items.add(new Item("N", "Nguyễn Thị Thơm", "Ngày 28.4, một lãnh đạo Viện KSND tỉnh Đắk Lắk xác nhận đơn vị này đã phê chuẩn các quyết định khởi tố 10 bị can - nguyên là lãnh đạo, cán bộ ngành y tế tỉnh để điều tra về hành vi “"));
        items.add(new Item("L", "Lê Thái bảo", "Ngoài ra, có 5 bị can khác đang công tác tại các bệnh viện và cơ sở y tế trên địa bàn tỉnh Đắk Lắk cũng bị khởi tố gồm: Nguyễn Sỹ, Lê Thị Thanh Bình, Tô Thị Hà, Lê Na Tơr và Mai Xuân Vinh."));
        items.add(new Item("Đ", "Đinh Thúy Hà", "Theo một lãnh đạo Công an tỉnh Đắk Lắk, hiện đơn vị đã bắt tạm giam 6 bị can trong thời hạn 3 tháng, gồm: Doãn Hữu Long, Nguyễn Hữu Huyên, Nguyễn Đình Quân, Nguyễn Đình Diệm, Nguyễn Sỹ và Lê Thị Thanh Bình."));
        items.add(new Item("G", "Giáp Ngọc Hiếu", "Theo hồ sơ từ hệ thống đấu thầu quốc gia, ngày 23.4, Công ty Phương Đông còn trúng gói thầu số 3: “Mua sắm máy chụp X-quang di động kỹ thuật số” của Sở Y tế Hải Phòng, giá trị 14 tỉ đồng. Tại Bệnh viện đa khoa Hải Dương, ngày 21.4, Công ty Phương Đông cũng trúng gói “Cung ứng vật tư thận nhân tạo phục vụ công tác chuyên môn” gần 1 tỉ đồng và gói “Mua lô vật tư tiêu hao phục vụ công tác chuyên môn” hơn 600 triệu đồng. Trong khoảng thời gian ngắn, công ty này thậm chí đã tham gia 123 gói thầu và trúng 115 gói."));
        items.add(new Item("H", "Hoàng Thị Hiền", "Tại Viện Vệ sinh dịch tễ T.Ư, công ty này trúng gói “Mua sinh phẩm, vật tư, hóa chất xét nghiệm SARS-CoV-2 và một số tác nhân khác gây bệnh đường hô hấp cấp tính”, trị giá hơn 3,7 tỉ đồng."));
        items.add(new Item("P", "Phùng Hà Dương", "Tại Ninh Bình, Công ty Tâm Việt cung cấp hệ thống xét nghiệm Realtime PCR với mức giá trúng khoảng 7,8 tỉ đồng. Công ty này đã từng liên danh với 20 nhà thầu trong 17 gói thầu và thắng thầu cả 17 gói. Ngoài các công ty Tâm Việt, Phương Đông, một loạt các công ty khác như: Công ty CP Giải pháp Việt, Công ty TNHH Tài Lộc, Công ty TNHH Việt Nam (MST) cũng trúng thầu nhiều gói thầu độc lập tại Thái Bình, Quảng Nam"));
        items.add(new Item("T", "Trịnh Hoàng Nah", "Tại Ninh Bình, Công ty Tâm Việt cung cấp hệ thống xét nghiệm Realtime PCR với mức giá trúng khoảng 7,8 tỉ đồng. Công ty này đã từng liên danh với 20 nhà thầu trong 17 gói thầu và thắng thầu cả 17 gói. Ngoài các công ty Tâm Việt, Phương Đông, một loạt các công ty khác như: Công ty CP Giải pháp Việt, Công ty TNHH Tài Lộc, Công ty TNHH Việt Nam (MST) cũng trúng thầu nhiều gói thầu độc lập tại Thái Bình, Quảng Nam"));
        items.add(new Item("N", "Nguyễn An", "Tại Ninh Bình, Công ty Tâm Việt cung cấp hệ thống xét nghiệm Realtime PCR với mức giá trúng khoảng 7,8 tỉ đồng. Công ty này đã từng liên danh với 20 nhà thầu trong 17 gói thầu và thắng thầu cả 17 gói. Ngoài các công ty Tâm Việt, Phương Đông, một loạt các công ty khác như: Công ty CP Giải pháp Việt, Công ty TNHH Tài Lộc, Công ty TNHH Việt Nam (MST) cũng trúng thầu nhiều gói thầu độc lập tại Thái Bình, Quảng Nam"));
        items.add(new Item("H", "Hà Thị Mai", "Tại Ninh Bình, Công ty Tâm Việt cung cấp hệ thống xét nghiệm Realtime PCR với mức giá trúng khoảng 7,8 tỉ đồng. Công ty này đã từng liên danh với 20 nhà thầu trong 17 gói thầu và thắng thầu cả 17 gói. Ngoài các công ty Tâm Việt, Phương Đông, một loạt các công ty khác như: Công ty CP Giải pháp Việt, Công ty TNHH Tài Lộc, Công ty TNHH Việt Nam (MST) cũng trúng thầu nhiều gói thầu độc lập tại Thái Bình, Quảng Nam"));
        items.add(new Item("Đ", "Đỗ Nam Anh", "Tại Ninh Bình, Công ty Tâm Việt cung cấp hệ thống xét nghiệm Realtime PCR với mức giá trúng khoảng 7,8 tỉ đồng. Công ty này đã từng liên danh với 20 nhà thầu trong 17 gói thầu và thắng thầu cả 17 gói. Ngoài các công ty Tâm Việt, Phương Đông, một loạt các công ty khác như: Công ty CP Giải pháp Việt, Công ty TNHH Tài Lộc, Công ty TNHH Việt Nam (MST) cũng trúng thầu nhiều gói thầu độc lập tại Thái Bình, Quảng Nam"));


    }


}
