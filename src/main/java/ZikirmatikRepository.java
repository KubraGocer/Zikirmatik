import java.sql.*;

public class ZikirmatikRepository {

    private Connection conn;
    private Statement st;
    private PreparedStatement prst;


    private void setConnection(){
        try{
            this.conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Zikirmatik","techpro","password");

        }catch (SQLException e ){
            System.out.println(e.getMessage());

        }

    }
    private void setStatement(){
        try{
            this.st= conn.createStatement();

        }catch (SQLException e ){

        }
    }
    private void setPreparedStatement(String sql){
        try{
            this.prst=conn.prepareStatement(sql);

        }catch (SQLException e ){

        }
    }

    public void getCount (){
      setConnection();
      setStatement();
      try {
          ResultSet rst = st.executeQuery("SELECT * FROM zikirmatik0 LIMIT 1");
          while (rst.next()) {
              int zikirID = rst.getInt("zikirmatik__id");
              int zikirCount = rst.getInt("zikir_count");
              PojoClass.countID = zikirID;
              PojoClass.count = zikirCount;
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
      }
    }

    public void updateCount (int id, int count) {
        setConnection();
        String updateQuery = "UPDATE zikirmatik0 SET zikir_count = ? WHERE zikirmatik__id = ?";
        setPreparedStatement(updateQuery);
        try {
            prst.setInt(1,count);
            prst.setInt(2,id);
            prst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
