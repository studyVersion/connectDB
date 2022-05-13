package ConnectDB;
import java.sql.*;

public class Ventas {
	
	
	public static void employeesName() throws SQLException {
		String cadena= "";
		int counter=1;
		
		  Connection connectdb = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
                                                              // for mysql : jdbc:mysql://localhost:3306/test", "example","password123"
 
          Statement myConexion = connectdb.createStatement(  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

          ResultSet myResult  = myConexion.executeQuery("SELECT nombre,apellidos FROM empleados");
          

             while(myResult.next()) {
            	 String firstName = myResult.getString("nombre");
                 String lastName = myResult.getString("apellidos");
            	 
                 if (myResult.getString("nombre").equals("Ana")) {
                	 myResult.updateString("nombre", "Anabelle"); 
                	 
                 }
                
                /* myResult.updateString("nombre", firstName.toUpperCase());
                 myResult.updateString("apellidos", lastName.toUpperCase());*/
                 myResult.updateRow();
                 
                 cadena ="Client N° "+counter+" "+myResult.getString("nombre")+" "+myResult.getString("apellidos");
                 System.out.println(cadena);
                 counter ++;	
             }
             myConexion.close();
            
	}

		
		


	public static void main(String[] args) throws SQLException {
		//Ventas a = new Ventas();
		/*Connection connectdb = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
                                                          // for mysql : jdbc:mysql://localhost:3306/test", "example","password123"
		
		Statement myConexion = connectdb.createStatement();
		
		ResultSet myResult  = myConexion.executeQuery("SELECT * FROM empleados");
	     
		while(myResult.next()) {
			System.out.println(myResult.getString("nombre"));
		}*/
		
		
		employeesName();
		
		}

}
