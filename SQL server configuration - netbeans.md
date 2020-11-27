* First, To allow TCP/IP port follow instructions in following links.

     * Video - https://www.youtube.com/watch?v=UwEi88Rch7U
     * Link (stackoverflow) - https://stackoverflow.com/questions/18841744/jdbc-connection-failed-error-tcp-ip-connection-to-host-failed
          

* Then, To add a new firewall rule follow instructions in following link.

     * Link (stackoverflow) - https://stackoverflow.com/questions/24592717/error-connection-refused-connect-verify-the-connection-properties
     

* Then, Create the Database using 'PDSA_CourseWork.sql' script.


* Then, Change the following lines in 'DB_Acess.java' file using 'your MSSQL server name', 'username' and 'password'.

     * String url = "jdbc:sqlserver://YOUR SERVER NAME\\SQLFULL:1433;databaseName=PDSACourseWork;";
     * String user = "Username";
     * String pass = "Password";
     
     
