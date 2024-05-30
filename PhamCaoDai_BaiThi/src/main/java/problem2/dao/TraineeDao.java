package problem2.dao;

import problem2.DatabaseConnection;
import problem2.entities.Trainee;
//import problem2.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraineeDao {
    public boolean save(Trainee trainee) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO `fas`.`employee` (`id`, `account`, `gender`, `status`) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, trainee.getTrainee_id());
            statement.setString(2, trainee.getAccount());
            statement.setString(3, trainee.getFull_name());
            statement.setBoolean(4, trainee.getGender());
            statement.setDate(5, trainee.getBirth_date());
            statement.setInt(6, trainee.getPhone_number());
            statement.setDouble(7, trainee.getGpa());
            statement.setString(8, trainee.getStatus());


            int affectedRows = statement.executeUpdate();
            return affectedRows == 1;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving trainee", e);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public boolean update(Trainee trainee) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE `fas`.`trainee` SET `gender` = ?, `status` = ? WHERE `account` = ?";
            statement = connection.prepareStatement(sql);
            // Thực thi câu lệnh được chuẩn bị
            statement.setBoolean(1, trainee.getGender());
            statement.setString(2, trainee.getStatus());
            statement.setString(3, trainee.getAccount());

            int affectedRows = statement.executeUpdate(); // Thực thi câu lệnh được chuẩn bị
            return affectedRows == 1;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving trainee", e);
        } finally {
            statement.close(); // Đóng câu lệnh chuẩn bị
            connection.close(); // Đóng kết nối với cơ sở dữ liệu
        }
    }

    public boolean removeLeaveTrainee(){
        Connection connection = DatabaseConnection.getConnection();
        String sql = "DELETE FROM `fas`.`trainee` WHERE (`status` = 'leave')";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
        Trainee trainee = new Trainee();
        TraineeDao traineeDao = new TraineeDao();
            System.out.print(traineeDao.update(trainee));
    }

    public List<Trainee> findFemaleTrainee() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Trainee> femaleTrainees = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM `fas`.`trainee` WHERE `gender` = ?";
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, false); // Set gender to false for female

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Đọc thông tin của mỗi nhân viên từ kết quả truy vấn và thêm vào danh sách
                Trainee trainee = new Trainee();
                trainee.setTrainee_id(resultSet.getInt("id"));
                trainee.setAccount(resultSet.getString("account"));
                trainee.setGender(resultSet.getBoolean("gender"));
                trainee.setStatus(resultSet.getString("status"));
                femaleTrainees.add(trainee);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding female employees", e);
        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return femaleTrainees;
    }

}

