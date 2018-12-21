import java.sql.*;

public class DB{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public void connect() {
        int i=3;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/mcieslik",
                            "mcieslik", "rzus5Eut4qTbzFM6");


        } catch (SQLException ex) {
            // handle any errors
            i--;
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("próba nr" + (3-i));
            if(i==0) System.exit(0);
        } catch (Exception e) {
            i--;
            e.printStackTrace();
            if(i==0) System.exit(0);
        }
    }

    public void listAll(){
        try {
            connect();
            pstmt = conn.prepareStatement("SELECT * FROM books");
            rs = pstmt.executeQuery();

            while(rs.next()){
                String id = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                System.out.println(id + "|" + title + "|" + author + "|" + year +"\n");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());

        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { }
                rs = null;
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) { }

                pstmt = null;
            }
        }
    }
    public void listByAuthor(String author){
        try {
            connect();
            pstmt = conn.prepareStatement("SELECT * FROM books WHERE author LIKE ?");
            pstmt.setString(1,"%"+author);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String id = rs.getString("isbn");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                System.out.println(id + "|" + title + "|" + author + "|" + year +"\n");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());

        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { }
                rs = null;
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) { }

                pstmt = null;
            }
        }
    }

    public void listByISBN(String isbn){
        try {
            connect();
            pstmt = conn.prepareStatement("SELECT * FROM books WHERE isbn LIKE ?");
            pstmt.setString(1,isbn);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String title = rs.getString("title");
                String author = rs. getString("author");
                int year = rs.getInt("year");
                System.out.println(isbn + "|" + title + "|" + author + "|" + year +"\n");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());

        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { }
                rs = null;
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) { }

                pstmt = null;
            }
        }
    }
    public void insertBook(String isbn,String title, String author,int year)throws Exception{
        connect();
        if(isbn.length()!=13){
            throw new Exception("isbn musi mieć 13 znaków");
        }
        pstmt = conn.prepareStatement("INSERT INTO books VALUES(?,?,?,?)");
        pstmt.setString(1, isbn);
        pstmt.setString(2, title);
        pstmt.setString(3, author);
        pstmt.setInt(4, year);
        pstmt.executeUpdate();
    }
}