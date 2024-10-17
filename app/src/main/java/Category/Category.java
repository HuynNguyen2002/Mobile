package Category;

public class Category {
    private String name;
    private int imageResId; // Dùng int nếu bạn đang lưu hình ảnh từ resource (R.drawable)

    public Category(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
