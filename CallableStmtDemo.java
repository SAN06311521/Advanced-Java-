import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStmtDemo
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/sanya";

    // Database credentials
    static final String USERNAME = "root";
    static final String PASSWORD = "sanya";

    public static void main(String[] args)
    {
        CallableStmtDemo cs = new CallableStmtDemo();

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("Enter City Id ( Enter 0 to exit ):");
            int cityId = scanner.nextInt();

            if (cityId == 0)
            {
                break;
            }

            cs.getCityName(cityId);

        }
        scanner.close();
    }

    private void getCityName(int cityId)
    {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try
        {
            //driver declaration
            Class.forName(JDBC_DRIVER);

            //establishing connection
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String plSql = "{call getCityName (?, ?)}";

            //creating a callable statement
            callableStatement = connection.prepareCall(plSql);

            //IN parameter
            callableStatement.setInt(1, cityId);

            //OUT parameter
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

            //Use execute method to run stored procedure.
            callableStatement.execute();

            //retrieving city name
            String cityName = callableStatement.getString(2);

            System.out.println("city Name : " + cityName);

        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (callableStatement != null)
                {
                    callableStatement.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }

    }
}