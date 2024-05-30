package problem1.entities;

import problem1.entities.SkillList;

public class SkillManagment {
    public static void main(String[] args) {
        SkillList skillList = new SkillList();
        System.out.println("Danh sách kỹ năng ban đầu:");
        skillList.display();

        System.out.println("\nCó 'Java' tồn tại không? " + skillList.getHead("Java"));
        System.out.println("Có 'Python' tồn tại không? " + skillList.getHead("Python"));

        System.out.println("\nĐang xóa 'Android'");
        System.out.println("Đã xóa thành công? " + skillList.remove("Android"));
        System.out.println("Danh sách kỹ năng sau khi xóa:");
        skillList.display();

        System.out.println("\nĐang cập nhật kỹ năng tại chỉ mục 2 thành 'Python'");
        skillList.update(2, "Python");
        System.out.println("Danh sách kỹ năng sau khi cập nhật:");
        skillList.display();
    }
}
